package org.team5.bank.core.server;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.Reader;
import java.net.Socket;
import java.util.Arrays;

import org.apache.commons.logging.Log; 
import org.apache.commons.logging.LogFactory;

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
			String response = processRequest(requestBuffer.toString());
			out.println(response);
			
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
		
		StringBuffer responseBuffer = new StringBuffer ();
		
		//FIXME : implement real logic 
		responseBuffer.append("success");
		responseBuffer.append(",");
		responseBuffer.append("responseData1");
		responseBuffer.append(",");
		responseBuffer.append("responseData2");
		responseBuffer.append(",");
		responseBuffer.append("responseData3");
		responseBuffer.append(",");
		responseBuffer.append("responseData4");
		responseBuffer.append(",");
		responseBuffer.append("responseData5");
		responseBuffer.append(",");
		
		return responseBuffer.toString();
	}

}
