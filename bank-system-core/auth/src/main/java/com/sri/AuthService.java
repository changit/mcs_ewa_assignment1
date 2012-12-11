package com.sri;

import javax.jws.WebService;

/**
 * User: Gihan Anuruddha
 * Date: 12/10/12
 */
@WebService(targetNamespace = "http://localhost:8080/bank-system-core-auth")
public interface AuthService {

    String login(String username, String passwordHash);
}
