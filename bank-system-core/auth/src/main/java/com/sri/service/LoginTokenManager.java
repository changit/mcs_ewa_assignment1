package com.sri.service;

import com.sri.model.LoginToken;
import com.sri.service.exception.UserNotFoundException;

/**
 * User: Gihan Anuruddha
 * Date: 12/16/12
 */
public interface LoginTokenManager {

    void saveLoginToken(LoginToken loginToken);

    boolean verifyToken(Long userId, String token) throws UserNotFoundException;
}
