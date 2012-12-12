package com.sri.service;

import com.sri.model.LoginCode;
import com.sri.model.LoginResponse;

import javax.jws.WebService;
import java.util.Random;

/**
 * User: Gihan Anuruddha
 * Date: 12/10/12
 */
@WebService(endpointInterface = "com.sri.service.AuthService")
public class AuthServiceImpl implements AuthService {

    @Override
    public LoginResponse authenticate(String username, String passwordHash) {

        LoginResponse response = new LoginResponse();

        Random ran = new Random();

        response.setUserId(String.valueOf(ran.nextLong()));
        response.setLoginToken(String.valueOf(ran.nextLong()));
        response.setResult(LoginCode.SUCCESS.name());

        return response;
    }
}
