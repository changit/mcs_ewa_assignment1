package abc.payment.client;

import com.sri.service.AuthService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SimpleClient {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("classpath*:client-spring-context.xml");
        AuthService authService = (AuthService) context.getBean("authService");

        System.out.println("authService.login() = " + authService.login("gihan", "test"));
    }
}
