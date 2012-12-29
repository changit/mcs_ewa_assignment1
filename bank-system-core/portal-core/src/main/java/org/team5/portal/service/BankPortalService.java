package org.team5.portal.service;

import org.iso8583.payload.FundTransfer;
import org.team5.portal.data.FundTransferRequest;
import org.team5.portal.data.FundTransferResponse;
import org.team5.portal.data.Transaction;

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

    FundTransferResponse transfer(FundTransferRequest request);

    List<Transaction> getAccountHistory(@WebParam(name = "accountNumber") String accountNo);

}
