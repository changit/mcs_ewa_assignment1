package org.team5.portal.service;

import org.iso8583.payload.FundTransfer;
import org.team5.portal.data.*;

import javax.jws.WebParam;
import javax.jws.WebService;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: chan
 * Date: 12/29/12
 * Time: 8:34 PM
 * To change this template use File | Settings | File Templates.
 */

@WebService(targetNamespace = "http://org.sribank.com/portal")
public interface BankPortalService {

    FundTransferResponse transfer(@WebParam(name="request") FundTransferRequest request);

    List<Transaction> getAccountHistory(@WebParam(name = "accountNumber") String accountNo);
    
    List<Account> getAccountList(@WebParam(name = "userId") String userId);

    List<CreditCardAccount> getCreditCardList(@WebParam(name = "userId") String userId);

    List<Transaction> getCreditCardTransactionByCardId(@WebParam(name = "cardId") String cardId);

}
