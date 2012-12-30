package org.team5.portal.service.impl;

import localhost._8080.bank_system_core_auth.AuthService;
import localhost._8080.bank_system_core_auth.UserNotFoundException_Exception;
import org.iso8583.payload.CoreServicePortType;
import org.iso8583.payload.FundTransfer;
import org.springframework.beans.factory.annotation.Autowired;
import org.team5.bank.core.server.service.model.xsd.TransactionResponse;
import org.team5.portal.FormatUtil;
import org.team5.portal.data.*;
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

    @Autowired
    private LegacyServiceMessageTransformer legacyTransformer;

    @Override
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
            TransactionResponse fundTransfer = legacyService.fundTransfer(request.getFromAccount(), request.getAmount(), Double.parseDouble(request.getAmount()));

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
    public List<Transaction> getAccountHistory(String accountNo) {
        Transaction transaction1 = new Transaction();
        transaction1.setAmount("1000");
        transaction1.setEffectiveDate(FormatUtil.formatDate(new Date()));
        transaction1.setTransactionDate(FormatUtil.formatDate(new Date()));
        transaction1.setDescription("Received 1000");
        transaction1.setType("CR");

        Transaction transaction2 = new Transaction();
        transaction2.setAmount("2000");
        transaction2.setEffectiveDate(FormatUtil.formatDate(new Date()));
        transaction2.setTransactionDate(FormatUtil.formatDate(new Date()));
        transaction2.setDescription("External Transfer to 95148731");
        transaction2.setType("DR");

        List<Transaction> transactionList = new ArrayList<Transaction>();
        transactionList.add(transaction1);
        transactionList.add(transaction2);
        return transactionList;
    }
    
    @Override
	public  List<Account> getAccountList(String userId){
    	List<Account> accountList = new ArrayList<Account>();
    	Account account= new Account();
    	account.setUserId(userId);
    	account.setAccountNo("1212121212121");
    	account.setAccountName("KWS CHandana");
    	account.setAccountType("Saving Account");
    	account.setBalance("10000.00");
    	account.setCurrency("LKR");
    	accountList.add(account);
    	return accountList;
    }

    @Override
    public List<CreditCardAccount> getCreditCardList(String userId) {

        List<CreditCardAccount> cards = new ArrayList<CreditCardAccount>();

        CreditCardAccount card1 = new CreditCardAccount();
        card1.setAccountNo("1245-1245-1245-0001");
        card1.setAccountName("User 1");
        card1.setCreditLimit("50000.00");
        card1.setIssuedData("2011/10/15");
        card1.setExpiredData("2014/10/15");
        card1.setAccountType("CreditCard");
        card1.setCurrency("LKR");
        card1.setBalance("-15236.78");
        card1.setUserId(userId);
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
        card2.setUserId(userId);
        cards.add(card2);

        return cards;
    }

    @Override
    public List<Transaction> getCreditCardTransactionByCardId(@WebParam(name = "cardId") String cardId) {
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

        List<Transaction> transactionList = new ArrayList<Transaction>();
        transactionList.add(transaction1);
        transactionList.add(transaction2);

        return transactionList;
    }
}
