package org.team5.bank.core.server.service;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.team5.bank.core.server.service.model.Account;
import org.team5.bank.core.server.service.model.WebService;

public class DepositService implements WebService {

	@Override
	public Map<String, String> invokeService(Map<String,String> param) throws ServiceException {
		Map<String, String> data = new HashMap<String, String>();
		String accountNo = param.get("accountNo");
		if(accountNo!=null && param.get("amount")!=null){
			Double amount= 0.0;
			try {
				amount = Math.abs(Double.parseDouble(param.get("amount")));
			} catch (NumberFormatException e) {
				throw new ServiceException("Amount is not a number!");
			}
			SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
	        Session session = sessionFactory.getCurrentSession();
	        Transaction tx = session.beginTransaction();
	        Query query = session.createQuery("from Account where accountNo = :accountNo");
	        query.setParameter("accountNo", param.get("accountNo"));
	        Account account = (Account) query.uniqueResult();
	        if(account!=null){
	        	double balance = account.getBalance();
	 	        balance+=amount;
	 			account.setBalance(balance);
	 			session.save(account);
	 			org.team5.bank.core.server.service.model.Transaction transaction = new org.team5.bank.core.server.service.model.Transaction();
	 			transaction.setFromAccount(account.getAccountNo());
	 			transaction.setToAccount(account.getAccountNo());
	 			transaction.setAmount(amount);
	 			transaction.setType("deposit");
	 			transaction.setTimeStamp(new Date());
	 			session.save(transaction);
	 			tx.commit();
	 			data.put("transactionID", transaction.getId().toString());
	 			data.put("status", "success");
	        } else{
	        	throw new ServiceException("Cannot find account with identifier '" + accountNo + "'");
	        }
	       
		} else{
			throw new ServiceException("arguments cannot be null or empty");
		}
		
		return data;
	}

}
