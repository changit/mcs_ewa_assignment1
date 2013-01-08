package com.sri.service.impl;

import com.sri.model.*;
import com.sri.service.AuthService;
import com.sri.service.LoginTokenManager;
import com.sri.service.UserManager;
import com.sri.service.exception.UserNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import javax.jws.WebService;
import javax.persistence.NoResultException;
import java.text.SimpleDateFormat;
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
    private UserManager userManager;

    @Autowired
    private LoginTokenManager loginTokenManager;

    private static SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    @Override
    @Transactional
    public LoginResponse authenticate(final String username, final String passwordHash, final String corporateId) {

        LoginResponse response = new LoginResponse();

        User user = null;
        try {
            user = userManager.findUserByUserName(username);
        } catch (NoResultException ex) {
            response.setResult(LoginCode.FAILED.name());
            response.setErrorMsg("Username or password invalid.");
        }

        if (user != null) {

            if (user.isAccountLock()) {
                response.setResult(LoginCode.FAILED.name());
                response.setErrorMsg("User account is locked. \n" +
                        "Please contact bank.");

            } else if ((user.getCorporateId() != null) && (corporateId == null)) {
                response.setResult(LoginCode.FAILED.name());
                response.setErrorMsg("Please enter Corporate ID.");
            } else {

                if (user.getPassword().equals(passwordHash)) {

                    if ((corporateId != null) && (!corporateId.equalsIgnoreCase(user.getCorporateId()))) {
                        response.setResult(LoginCode.FAILED.name());
                        response.setErrorMsg("Invalid Corporate ID.");
                    } else {
                        Random ran = new Random(new Date().getTime());
                        Long token = Math.abs(ran.nextLong());
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

                        LoginToken lastLoginToken = loginTokenManager.getLastLoginTokenByUserId(user.getId());
                        if (lastLoginToken != null) {
                            response.setLastLoginTime(dateFormat.format(lastLoginToken.getTokenCreatedTime()));
                        }

                        // save login token details
                        LoginToken loginToken = new LoginToken();
                        loginToken.setUserId(user.getId());
                        loginToken.setLoginToken(String.valueOf(token));
                        loginToken.setTokenCreatedTime(new Date());

                        loginTokenManager.saveLoginToken(loginToken);

                        if (user.getInvalidPasswordCount() != 0) {
                            user.setInvalidPasswordCount(0);
                            userManager.updateUser(user);
                        }
                    }

                } else {
                    user.setInvalidPasswordCount(user.getInvalidPasswordCount() + 1);

                    if (user.getInvalidPasswordCount() >= 3) {
                        user.setAccountLock(true);
                    }

                    userManager.updateUser(user);

                    response.setResult(LoginCode.FAILED.name());
                    if (user.getInvalidPasswordCount() == 3) {
                        response.setErrorMsg("Invalid Password. Your account is locked now. \n Please contact bank.");
                    } else {
                        response.setErrorMsg("Invalid Password. \nYou are left with " + (3 - user.getInvalidPasswordCount()) + " more attempts");

                    }
                }
            }
        }

        return response;
    }

    @Override
    public boolean verifyToken(Long userId, String token) throws UserNotFoundException {
        return loginTokenManager.verifyToken(userId, token);
    }
}
