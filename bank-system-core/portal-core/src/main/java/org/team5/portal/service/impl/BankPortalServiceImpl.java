package org.team5.portal.service.impl;

import localhost._8080.bank_system_core_auth.AuthService;
import localhost._8080.bank_system_core_auth.UserNotFoundException_Exception;
import org.iso8583.payload.CoreServicePortType;
import org.iso8583.payload.FundTransfer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.team5.bank.core.server.service.model.xsd.*;
import org.team5.portal.FormatUtil;
import org.team5.portal.data.*;
import org.team5.portal.data.Account;
import org.team5.portal.data.Transaction;
import org.team5.portal.service.BankPortalService;

import javax.jws.WebParam;
import javax.jws.WebService;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: chan
 * Date: 12/29/12
 * Time: 8:51 PM
 * To change this template use File | Settings | File Templates.
 */
@WebService(endpointInterface = "org.team5.portal.service.BankPortalService")
public class BankPortalServiceImpl implements BankPortalService {

    @Autowired
    private CoreServicePortType legacyService;

    @Autowired
    private AuthService authService;

    @Override
    @Transactional
    public FundTransferResponse transfer(FundTransferRequest request) {

        FundTransferResponse fundTransferResponse = new FundTransferResponse();
        boolean authorized = false;
        try {
            authorized = authService.verifyToken(request.getUserId(), request.getLoginToken());
        } catch (UserNotFoundException_Exception e) {
            fundTransferResponse.setResultCode(FundTransferCode.FAILED_0001);
            fundTransferResponse.setDescription("Invalid user.");
        }

        if (authorized) {
            TransactionResponse fundTransfer = legacyService.fundTransfer(request.getFromAccount(), request.getToAccount(), Double.parseDouble(request.getAmount()));

            fundTransferResponse.setDescription("Money Transferred successfully");
            fundTransferResponse.setResultCode(FundTransferCode.SUCCESS_0000);
            fundTransferResponse.setTransactionId(String.valueOf(fundTransfer.getTransactionID().getValue()));
            fundTransferResponse.setSourceId(request.getRequestId());
        } else {
            fundTransferResponse.setResultCode(FundTransferCode.FAILED_0001);
            fundTransferResponse.setDescription("Invalid login token.");
        }
        return fundTransferResponse;
    }

    @Override
    public List<Transaction> getAccountHistory(String accountNo, Long userId, String loginToken) {

        List<Transaction> transactionList = new ArrayList<Transaction>();

        if(!verifyUser(userId, loginToken)) {
            return transactionList;
        }

        List<org.team5.bank.core.server.service.model.xsd.Transaction> transactionHistory = legacyService.getTransactionHistory(accountNo);
        for (org.team5.bank.core.server.service.model.xsd.Transaction transaction : transactionHistory) {
            transactionList.add(transform(transaction));
        }

        return transactionList;
    }

    private boolean verifyUser(Long userId, String loginToken){
        try {
            return authService.verifyToken(userId, loginToken);
        } catch (UserNotFoundException_Exception e) {
            return false;
        }
    }

    private Transaction transform(org.team5.bank.core.server.service.model.xsd.Transaction transaction) {
        Transaction trx = new Transaction();
        trx.setAmount(String.valueOf(transaction.getAmount()));
        trx.setEffectiveDate(transaction.getTimeStamp().getValue().toString());
        trx.setTransactionDate(transaction.getTimeStamp().getValue().toString());
        if(transaction.getType().getValue().equals("deposit")) {
            trx.setType("CR");
            trx.setDescription("Money Transferred to [" + transaction.getToAccount().getValue() + "] Account");
        } else {
            trx.setType("DR");
            trx.setDescription("Money received from [ " + transaction.getFromAccount().getValue() + " Account]");
        }
        return trx;
    }


    @Override
	public  List<Account> getAccountList(Long userId,String loginToken){
        org.team5.bank.core.server.service.model.xsd.Account account1 = legacyService.getAccount(userId);
        List<Account> accountList = new ArrayList<Account>();
    	Account account= new Account();
    	account.setUserId(String.valueOf(account1.getUserId()));
    	account.setAccountNo(account1.getAccountNo().getValue());
    	account.setAccountName("");
    	account.setAccountType(account1.getDescription().getValue());
    	account.setBalance(String.valueOf(account1.getBalance()));
    	account.setCurrency("LKR");
    	accountList.add(account);
    	return accountList;
    }

    @Override
    public List<CreditCardAccount> getCreditCardList(Long userId, String loginToken) {

        List<CreditCardAccount> cards = new ArrayList<CreditCardAccount>();

        if(!verifyUser(userId, loginToken)) {
            return cards;
        }

        CreditCardAccount card1 = new CreditCardAccount();
        card1.setAccountNo("1245-1245-1245-0001");
        card1.setAccountName("User 1");
        card1.setCreditLimit("50000.00");
        card1.setIssuedData("2011/10/15");
        card1.setExpiredData("2014/10/15");
        card1.setAccountType("CreditCard");
        card1.setCurrency("LKR");
        card1.setBalance("-15236.78");
        card1.setUserId("" + userId);
        cards.add(card1);

        CreditCardAccount card2 = new CreditCardAccount();
        card2.setAccountNo("1245-1245-1245-0002");
        card2.setAccountName("User 2");
        card2.setCreditLimit("100000.00");
        card2.setIssuedData("2012/10/15");
        card2.setExpiredData("2015/10/15");
        card2.setAccountType("CreditCard");
        card2.setCurrency("LKR");
        card2.setBalance("-25014.50");
        card2.setUserId("" + userId);
        cards.add(card2);

        return cards;
    }

    @Override
    public List<Transaction> getCreditCardTransactionByCardId(@WebParam(name = "cardId") String cardId, Long userId, String loginToken) {

        List<Transaction> transactionList = new ArrayList<Transaction>();

        if(!verifyUser(userId, loginToken)) {
            return transactionList;
        }

        Transaction transaction1 = new Transaction();
        transaction1.setAmount("1000");
        transaction1.setEffectiveDate(FormatUtil.formatDate(new Date()));
        transaction1.setTransactionDate(FormatUtil.formatDate(new Date()));
        transaction1.setDescription("Internal Transfer to 1245124522");
        transaction1.setType("CR");

        Transaction transaction2 = new Transaction();
        transaction2.setAmount("2000");
        transaction2.setEffectiveDate(FormatUtil.formatDate(new Date()));
        transaction2.setTransactionDate(FormatUtil.formatDate(new Date()));
        transaction2.setDescription("External Transfer to 95148731");
        transaction2.setType("CR");

        transactionList.add(transaction1);
        transactionList.add(transaction2);

        return transactionList;
    }
}
