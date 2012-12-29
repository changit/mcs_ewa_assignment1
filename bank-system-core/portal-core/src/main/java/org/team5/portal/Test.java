package org.team5.portal;

import localhost._8080.bank_system_core_auth.AuthService;
import localhost._8080.bank_system_core_auth.LoginResponse;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created with IntelliJ IDEA.
 * User: chan
 * Date: 12/29/12
 * Time: 7:28 PM
 * To change this template use File | Settings | File Templates.
 */
public class Test {

    @Autowired
    AuthService authService;

    public void init(){
        LoginResponse loginResponse = authService.authenticate("2998821", "test");
        System.out.println("XXX " + loginResponse.getResult());
        System.out.println("XXX " + loginResponse.getLoginToken());
    }
}
