package com.sri.service;

import com.sri.model.LoginResponse;

import javax.jws.WebService;

/**
 * User: Gihan Anuruddha
 * Date: 12/10/12
 */
@WebService(targetNamespace = "http://localhost:8080/bank-system-core-auth")
public interface AuthService {

    LoginResponse authenticate(String username, String passwordHash);
}
