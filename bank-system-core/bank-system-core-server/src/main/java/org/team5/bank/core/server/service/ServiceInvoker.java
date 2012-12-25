package org.team5.bank.core.server.service;

import java.util.HashMap;
import java.util.Map;

import org.team5.bank.core.server.service.model.WSResult;
import org.team5.bank.core.server.service.model.WSResult.Status;
import org.team5.bank.core.server.service.model.WebService;


public class ServiceInvoker {
	
	private static Map<String,WebService> serviceClasses = new HashMap<String, WebService>();
	
	static{
		serviceClasses.put("deposit", new DepositService());
		serviceClasses.put("withdraw", new WithdrawService());
	}
	
	public WSResult invokeService(String action, Map<String,String> param){
		WSResult result = null;
		
		WebService webService = serviceClasses.get(action);
		if(webService!=null){
			try {
				StringBuffer buffer = new StringBuffer ();
				Map<String, String> values = webService.invokeService(param);
				for (Map.Entry<String, String> entry :values.entrySet()){
					buffer.append(entry.getKey());
					buffer.append("=");
					buffer.append(entry.getValue());
					buffer.append(",");
					result = new WSResult();
					result.setStatus(Status.SUCCESS);
					result.setValues(buffer.toString());
				}
			} catch (ServiceException e) {
				result = new WSResult();
				result.setStatus(Status.FAILED);
				result.setErrorMsg(e.getMessage());
			}
		} else{
			result = new WSResult();
			result.setStatus(Status.FAILED);
			result.setErrorMsg("Action not found");
		}
		
		return result;
		
	}

}
