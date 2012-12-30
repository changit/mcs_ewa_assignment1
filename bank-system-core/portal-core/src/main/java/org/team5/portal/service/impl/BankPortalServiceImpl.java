package org.team5.portal.service.impl;

import localhost._8080.bank_system_core_auth.AuthService;
import org.iso8583.payload.CoreServicePortType;
import org.iso8583.payload.FundTransfer;
import org.springframework.beans.factory.annotation.Autowired;
import org.team5.portal.FormatUtil;
import org.team5.portal.data.Account;
import org.team5.portal.data.FundTransferCode;
import org.team5.portal.data.FundTransferRequest;
import org.team5.portal.data.FundTransferResponse;
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

    @Autowired
    private LegacyServiceMessageTransformer legacyTransformer;

    @Override
    public FundTransferResponse transfer(FundTransferRequest request) {
        //TODO authenticate validation
        //authService.checkTransactionId

        String fundTransfer = legacyService.fundTransfer(request.getFromAccount(), request.getAmount(), Double.parseDouble(request.getAmount()));

        FundTransferResponse fundTransferResponse = new FundTransferResponse();
        fundTransferResponse.setDescription("Money Transferred successfully");
        fundTransferResponse.setResultCode(FundTransferCode.SUCCESS_0000);
        fundTransferResponse.setTransactionId("1597538264");
        fundTransferResponse.setSourceId(request.getRequestId());
        return fundTransferResponse;
    }

    @Override
    public List<Transaction> getAccountHistory(String accountNo) {
        Transaction transaction1 = new Transaction();
        transaction1.setWithdrawal("1000");
        transaction1.setEffectiveDate(FormatUtil.formatDate(new Date()));
        transaction1.setTransactionDate(FormatUtil.formatDate(new Date()));
        transaction1.setDescription("Internal Transfer to 1245124522");

        Transaction transaction2 = new Transaction();
        transaction2.setWithdrawal("2000");
        transaction2.setEffectiveDate(FormatUtil.formatDate(new Date()));
        transaction2.setTransactionDate(FormatUtil.formatDate(new Date()));
        transaction2.setDescription("External Transfer to 95148731");

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
    	account.setAccountName("Saving account");
    	accountList.add(account);
    	return accountList;
    }
}
