package org.team5.utility.bill.service.connectors;

import org.team5.utility.bill.data.PayBillReceipt;
import org.team5.utility.bill.service.MerchantConnector;

/**
 * Created with IntelliJ IDEA.
 * User: chan
 * Date: 1/16/13
 * Time: 10:26 PM
 * To change this template use File | Settings | File Templates.
 */
public class EtisalatConnector implements MerchantConnector {

    @Override
    public boolean notifyMerchant(PayBillReceipt payBillReceipt) {
        System.out.println("Bill payment receipt received to Etisalat Connector" + payBillReceipt);
        return true;
    }
}
