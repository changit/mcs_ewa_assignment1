package org.team5.utility.bill.service.connectors;

import com.dialog.org.billing.BillPaymentListenerService;
import com.dialog.org.billing.BillReceipt;
import org.springframework.beans.factory.annotation.Autowired;
import org.team5.utility.bill.data.PayBillReceipt;
import org.team5.utility.bill.service.MerchantConnector;

import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: chan
 * Date: 1/16/13
 * Time: 10:26 PM
 * To change this template use File | Settings | File Templates.
 */
public class DialogConnector implements MerchantConnector {

    @Autowired
    BillPaymentListenerService billPaymentListenerService;

    @Override
    public boolean notifyMerchant(PayBillReceipt payBillReceipt) {
        try {
            System.out.println("Bill payment receipt received to Dialog Connector" + payBillReceipt);
            BillReceipt billReceipt = new BillReceipt();
            billReceipt.setAccountNo(payBillReceipt.getAccountNo());
            billReceipt.setAmount(payBillReceipt.getAmount());
            billReceipt.setDateTime((new Date()).toString());
            billPaymentListenerService.billPaid(billReceipt);
        } catch (Exception e) {
            System.err.println("Unexpected error occurred");
            e.printStackTrace();
        }
        return true;
    }
}
