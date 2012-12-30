package org.team5.bank.core.server.service;

import java.util.HashMap;
import java.util.Map;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.team5.bank.core.server.service.model.Account;
import org.team5.bank.core.server.service.model.WebService;

public class GetAccountService implements WebService {

	@Override
	public Map<String, String> invokeService(Map<String, String> param)
			throws ServiceException {
		Map<String, String> data = new HashMap<String, String>();
		String userId = param.get("userId");
		if(userId!=null){
			SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
	        Session session = sessionFactory.getCurrentSession();
	        Transaction tx = session.beginTransaction();
	        Query query = session.createQuery("from Account where userId = :userId");
	        query.setParameter("userId", Long.parseLong(param.get("userId")));
	        Account account = (Account) query.uniqueResult();
	        if(account!=null){
	        	data.put("id", account.getId().toString());
	        	data.put("userId", "" + account.getUserId());
	        	data.put("accountNo", account.getAccountNo());
	        	data.put("balance", ""+ account.getBalance());
	        	data.put("description", account.getDescription());
	        } else{
	        	throw new ServiceException("Cannot find account for user '" + userId + "'");
	        }
	       
		} else{
			throw new ServiceException("arguments cannot be null or empty");
		}
		return data;
	}
	
}
