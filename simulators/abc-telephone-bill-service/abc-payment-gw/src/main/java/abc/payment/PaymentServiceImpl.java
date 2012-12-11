package abc.payment;

import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;

@WebService(endpointInterface = "abc.payment.PaymentService")
public class PaymentServiceImpl implements PaymentService {

	public PaymentResponse payBill(PaymentRequest paymentRequest) {
		PaymentResponse paymentResponse = new PaymentResponse();
        paymentResponse.setPaymentCode(PaymentCode.SUCCESS);
        return paymentResponse;
	}
}
