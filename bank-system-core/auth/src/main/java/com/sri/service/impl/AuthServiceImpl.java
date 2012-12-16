package com.sri.service.impl;

import com.sri.model.LoginCode;
import com.sri.model.LoginResponse;
import com.sri.model.LoginToken;
import com.sri.model.Role;
import com.sri.model.User;
import com.sri.service.AuthService;
import com.sri.service.LoginTokenManager;
import com.sri.service.UserService;
import com.sri.service.exception.UserNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import javax.jws.WebService;
import javax.persistence.NoResultException;
import java.util.Date;
import java.util.Iterator;
import java.util.Random;

/**
 * User: Gihan Anuruddha
 * Date: 12/10/12
 */
@WebService(endpointInterface = "com.sri.service.AuthService")
public class AuthServiceImpl implements AuthService {

    @Autowired
    private UserService userService;

    @Autowired
    private LoginTokenManager loginTokenManager;

    @Override
    @Transactional
    public LoginResponse authenticate(String username, String passwordHash) {

        LoginResponse response = new LoginResponse();

        User user = null;
        try {
            user = userService.findUserByUserName(username);
        } catch (NoResultException ex) {
            response.setResult(LoginCode.FAILED.name());
            response.setErrorMsg(ex.getMessage());
        }

        if (user != null) {
            Random ran = new Random(new Date().getTime());
            Long token = ran.nextLong();
            response.setUserId(String.valueOf(user.getId()));
            response.setLoginToken(String.valueOf(token));
            response.setResult(LoginCode.SUCCESS.name());

            if (user.getRoles() != null) {
                String[] roles = new String[user.getRoles().size()];
                Iterator<Role> it = user.getRoles().iterator();
                int i = 0;
                while (it.hasNext()) {
                    Role role = it.next();
                    roles[i++] = role.getName();
                }

                response.setRoles(roles);
            }

            // save login token details
            LoginToken loginToken = new LoginToken();
            loginToken.setUserId(user.getId());
            loginToken.setLoginToken(String.valueOf(token));
            loginToken.setTokenCreatedTime(new Date());

            loginTokenManager.saveLoginToken(loginToken);
        }

        return response;
    }
}
