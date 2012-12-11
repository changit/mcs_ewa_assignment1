package abc.payment;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;

@WebService(targetNamespace = "http://localhost:8080/abc-payment-gw")
@SOAPBinding
public interface PaymentService {

    @WebMethod
    PaymentResponse payBill(PaymentRequest paymentRequest);
    
}
