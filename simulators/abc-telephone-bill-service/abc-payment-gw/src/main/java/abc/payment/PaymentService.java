package abc.payment;

import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService(targetNamespace = "http://localhost:8080/abc-payment-gw")
public interface PaymentService {

    PaymentResponse payBill(PaymentRequest paymentRequest);
    
}
