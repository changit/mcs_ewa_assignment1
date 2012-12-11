package com.sri;

import javax.jws.WebService;

/**
 * User: Gihan Anuruddha
 * Date: 12/10/12
 */
@WebService(endpointInterface = "com.sri.AuthService")
public class AuthServiceImpl implements AuthService {

    @Override
    public String login(String username, String passwordHash) {
        return "Hello " + username;
    }
}
