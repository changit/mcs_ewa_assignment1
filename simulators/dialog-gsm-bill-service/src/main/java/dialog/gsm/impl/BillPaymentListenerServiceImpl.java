package dialog.gsm.impl;

import dialog.gsm.BillPaymentListenerService;
import dialog.gsm.BillReceipt;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

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

    private static Logger logger = LoggerFactory.getLogger(BillPaymentListenerServiceImpl.class);

    @Override
    public boolean billPaid(BillReceipt billReceipt) {
        logger.info("Notification Received [{}]", billReceipt);
        return true;
    }
}
