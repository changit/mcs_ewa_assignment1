package org.team5.bank.core.server.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.team5.bank.core.server.service.model.WebService;
import java.text.SimpleDateFormat;

public class TransactionHistoryService implements WebService {

	@Override
	public Map<String, String> invokeService(Map<String, String> param)
			throws ServiceException {
		Map<String, String> data = new HashMap<String, String>();
		String accountNo = param.get("accountNo");
		if(accountNo!=null){
			SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
	        Session session = sessionFactory.getCurrentSession();
	        Transaction tx = session.beginTransaction();
	        Query query = session.createQuery("from Transaction where fromAccount = :accountNo");
	        query.setParameter("accountNo", accountNo);
	        @SuppressWarnings("unchecked")
			List<org.team5.bank.core.server.service.model.Transaction> transactions =  query.list();
	        if(transactions.size()>0){
	        	StringBuffer idList = new StringBuffer("[");
	        	StringBuffer accountList = new StringBuffer("[");
	        	StringBuffer toAccountList = new StringBuffer("[");
	        	StringBuffer typeList = new StringBuffer("[");
	        	StringBuffer amountList = new StringBuffer("[");
	        	StringBuffer timeStampList = new StringBuffer("[");
	        	for (org.team5.bank.core.server.service.model.Transaction transaction : transactions) {
	        		idList.append(transaction.getId());
	        		idList.append("::");
	        		accountList.append(transaction.getFromAccount());
	        		accountList.append("::");
	        		toAccountList.append(transaction.getToAccount());
	        		toAccountList.append("::");
	        		typeList.append(transaction.getType());
	        		typeList.append("::");
	        		amountList.append(transaction.getAmount());
	        		amountList.append("::");
				SimpleDateFormat timeStampF = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZZ");
	        		timeStampList.append(timeStampF.format(transaction.getTimeStamp()));
	        		timeStampList.append("::");
				}
	        	data.put("id", idList.toString().replaceAll("::$","]"));
	        	data.put("fromAccount", accountList.toString().replaceAll("::$","]"));
	        	data.put("toAccount", toAccountList.toString().replaceAll("::$","]"));
	        	data.put("type", ""+ typeList.toString().replaceAll("::$","]"));
	        	data.put("amount", amountList.toString().replaceAll("::$","]"));
	        	data.put("timeStamp", timeStampList.toString().replaceAll("::$","]"));
	        } else{
	        	throw new ServiceException("Cannot find account '" + accountNo + "'");
	        }
	       
		} else{
			throw new ServiceException("arguments cannot be null or empty");
		}
		data.put("sys:map", "true");
		return data;
	}

}
