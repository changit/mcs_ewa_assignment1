package dialog.gsm;

import javax.jws.WebService;

/**
 * Created with IntelliJ IDEA.
 * User: chan
 * Date: 1/17/13
 * Time: 10:48 PM
 * To change this template use File | Settings | File Templates.
 */
@WebService(targetNamespace = "http://org.dialog.com/billing")
public interface BillPaymentListenerService {

    boolean billPaid(BillReceipt billReceipt);
}
