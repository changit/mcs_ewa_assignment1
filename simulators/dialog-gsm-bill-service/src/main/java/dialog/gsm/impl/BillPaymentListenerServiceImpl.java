package dialog.gsm.impl;

import dialog.gsm.BillPaymentListenerService;
import dialog.gsm.BillReceipt;

import javax.jws.WebService;

/**
 * Created with IntelliJ IDEA.
 * User: chan
 * Date: 1/17/13
 * Time: 10:52 PM
 * To change this template use File | Settings | File Templates.
 */
@WebService(endpointInterface = "dialog.gsm.BillPaymentListenerService")
public class BillPaymentListenerServiceImpl implements BillPaymentListenerService {

    @Override
    public boolean billPaid(BillReceipt billReceipt) {
        System.out.println("Bill Receipt Received accNo [ " + billReceipt.getAccountNo() + " ] amount [ " + billReceipt.getAmount() + " ]");
        return true;
    }
}
