package org.team5.utility.bill.service;

import org.team5.utility.bill.data.PayBillReceipt;

/**
 * Created with IntelliJ IDEA.
 * User: chan
 * Date: 1/16/13
 * Time: 10:21 PM
 * To change this template use File | Settings | File Templates.
 */
public interface MerchantConnector {

    boolean notifyMerchant(PayBillReceipt payBillReceipt);
}
