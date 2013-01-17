package org.team5.utility.bill.service;

import org.team5.utility.bill.data.Merchant;
import org.team5.utility.bill.data.PayBillRequest;
import org.team5.utility.bill.data.PayBillResponse;

import javax.jws.WebService;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: chan
 * Date: 12/29/12
 * Time: 9:52 PM
 * To change this template use File | Settings | File Templates.
 */
@WebService(targetNamespace = "http://org.sribank.com/utility")
public interface UtilityBillService {

    List<Merchant> getMerchantList();

    PayBillResponse pay(PayBillRequest payBillRequest);

}
