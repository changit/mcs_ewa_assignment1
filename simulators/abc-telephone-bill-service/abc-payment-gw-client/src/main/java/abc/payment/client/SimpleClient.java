package abc.payment.client;

import abc.payment.PaymentRequest;
import abc.payment.PaymentResponse;
import abc.payment.PaymentService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import sec.ClientPasswordCallback;

public class SimpleClient {

    public static void main(String[] args) {


        ApplicationContext context = new ClassPathXmlApplicationContext("classpath*:client-spring-context.xml");
        PaymentService paymentService = (PaymentService) context.getBean("paymentService");
        PaymentRequest paymentRequest = new PaymentRequest();
        paymentRequest.setAmount("10");
        paymentRequest.setAccountNumber("12121212");
        PaymentResponse paymentResponse = paymentService.payBill(paymentRequest);
        System.out.println("Response Received " + paymentResponse);

    }
}
