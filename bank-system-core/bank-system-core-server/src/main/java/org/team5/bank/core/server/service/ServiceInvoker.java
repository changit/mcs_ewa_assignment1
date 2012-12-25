package org.team5.bank.core.server.service;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.team5.bank.core.server.service.model.Account;
import org.team5.bank.core.server.service.model.WSResult;
import org.team5.bank.core.server.service.model.WSResult.Status;
import org.team5.bank.core.server.service.model.WebService;


public class ServiceInvoker {
	
	private static Map<String,WebService> serviceClasses = new HashMap<String, WebService>();
	
	static{
		serviceClasses.put("deposit", new DepositService());
	}
	
	/*public void Test(){
		  SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
	        Session session = sessionFactory.getCurrentSession();
	        Transaction tx = session.beginTransaction();
	        @SuppressWarnings("unchecked")
			List<Account> accounts = session.createQuery("from Account").list();
	        for (Account account : accounts) {
	            System.out.println("Id=" + account.getId());
	            System.out.println("UserId=" + account.getUserId());
	            System.out.println("AccountNo=" + account.getAccountNo());
	            System.out.println("Balance=" + account.getBalance());
	        }
	}*/
	
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
