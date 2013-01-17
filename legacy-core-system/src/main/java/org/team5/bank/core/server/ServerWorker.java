package org.team5.bank.core.server;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.Reader;
import java.net.Socket;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;

import org.apache.commons.logging.Log; 
import org.apache.commons.logging.LogFactory;
import org.team5.bank.core.server.service.ServiceInvoker;
import org.team5.bank.core.server.service.model.WSResult;
import org.team5.bank.core.server.service.model.WSResult.ResultType;
import org.team5.bank.core.server.service.model.WSResult.Status;

public class ServerWorker implements Runnable {
	
	private static Log log = LogFactory.getLog(ServerWorker.class); 
	private Socket socket;

	public ServerWorker(Socket socket) {
		this.socket = socket;
	}

	@Override
	public void run() {

		log.info("Connection successful: " + socket.getRemoteSocketAddress());
	    log.info("Waiting for input.....");
	    
	    PrintWriter out = null;
	    Reader reader = null;
		try {
			out = new PrintWriter(socket.getOutputStream(), true);
			reader = new InputStreamReader(new BufferedInputStream(
					socket.getInputStream()));
			char[] buffer = new char[1024];
			
			StringBuffer requestBuffer = new StringBuffer ();
			
			int read = 0;
			while ((read = reader.read(buffer)) != -1) {
				
				requestBuffer.append(Arrays.copyOf(buffer, read));
				if (read < 1024)
					break;
			}
			
			log.info("Processing request.....");
			log.info("***** ISO8583 Request : " + requestBuffer.toString());
			String response = processRequest(requestBuffer.toString());
			log.info("***** ISO8583 Response : " + response);
			out.print(response);
			
		} catch (IOException e) {
			log.error("An error has occurred",e);
		} finally {
			try {
				if (out != null)
					out.close();
					
				if (reader != null)
					reader.close();

				if (!socket.isClosed()){
					socket.close();
					log.info("Closing socket connection.....");
				}
					
			} catch (IOException e) {
				log.error("An error has occurred",e);
			}
		}

	}
	
	private String processRequest(String request){
		String action = null;
		WSResult result = null;
		Map<String,String> params = new LinkedHashMap<String, String>();
		StringBuffer responseBuffer = new StringBuffer ();
		
		String[] keyValuePairs = request.split(",");
		for (String keyValuePair : keyValuePairs) {
			String key = keyValuePair.split("=")[0];
			String value = keyValuePair.split("=")[1];
			if("action".equals(key)){
				action = value;
			} else{
				params.put(key, value);
			}
		}
		if(action!=null && !action.trim().isEmpty()){
			ServiceInvoker invoker = new ServiceInvoker();
			result = invoker.invokeService(action, params);
		}
		
		if(result==null){
			result = new WSResult();
			result.setStatus(Status.FAILED);
			result.setErrorMsg("no action specified");
			action= "error";
		}
		
		responseBuffer.append("action=");
		responseBuffer.append(action);
		responseBuffer.append("Response");
		responseBuffer.append(",");
		if(result.getStatus()==Status.SUCCESS){
			responseBuffer.append("sys:status=success");
			responseBuffer.append(",");
			if(result.getResultType()==ResultType.MAP){
				responseBuffer.append("sys:resultType=map");
				responseBuffer.append(",");
			}
			responseBuffer.append(result.getValues());
		} else{
			responseBuffer.append("sys:status=failed");
			responseBuffer.append(",");
			responseBuffer.append("error=" + result.getErrorMsg() );
			responseBuffer.append(",");
		}
		
		return responseBuffer.toString().replaceAll(",$", "");
	}

}
