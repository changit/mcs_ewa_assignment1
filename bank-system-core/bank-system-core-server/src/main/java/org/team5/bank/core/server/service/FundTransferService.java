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

public class FundTransferService implements WebService {

	@Override
	public Map<String, String> invokeService(Map<String, String> param)
			throws ServiceException {
		Map<String, String> data = new HashMap<String, String>();
		String fromAccountId = param.get("from");
		String toAccountId = param.get("to");
		if(fromAccountId!=null && toAccountId!=null &&param.get("amount")!=null){
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
	        query.setParameter("accountNo", fromAccountId);
	        Account accountFrom = (Account) query.uniqueResult();
	        query = session.createQuery("from Account where accountNo = :accountNo");
	        query.setParameter("accountNo", toAccountId);
	        Account accountTo = (Account) query.uniqueResult();
	        if(accountFrom!=null && accountTo!=null){
	        	double payerBalance = accountFrom.getBalance();
	        	if(amount <=payerBalance){
	        		try {
	        			double payeeBalance = accountTo.getBalance();
						payerBalance -= amount;
						payeeBalance += amount;
						accountFrom.setBalance(payerBalance);
						accountTo.setBalance(payeeBalance);
						session.save(accountFrom);
						session.save(accountTo);
						org.team5.bank.core.server.service.model.Transaction transaction = new org.team5.bank.core.server.service.model.Transaction();
			 			transaction.setFromAccount(accountFrom.getAccountNo());
			 			transaction.setToAccount(accountTo.getAccountNo());
			 			transaction.setAmount(amount);
			 			transaction.setType("transfer");
			 			transaction.setTimeStamp(new Date());
			 			session.save(transaction);
			 			tx.commit();
			 			data.put("transactionID", transaction.getId().toString());
					} catch (Exception e) {
						tx.rollback();
						throw new ServiceException("unknown error occurred: " + e);
					}
	        	} else{
	        		throw new ServiceException("Account has insufficient funds");
	        	}
	 	       
	        } else{
	        	throw new ServiceException("Cannot find account with identifier '" + accountFrom + "' or '" + accountTo + "'" );
	        }
	       
		} else{
			throw new ServiceException("arguments cannot be null or empty");
		}
		
		return data;
	}

}
