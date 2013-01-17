package com.sri.service.impl;

import com.sri.dao.LoginTokenDao;
import com.sri.model.LoginToken;
import com.sri.service.LoginTokenManager;
import com.sri.service.exception.UserNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.NoResultException;
import java.util.Calendar;

/**
 * User: Gihan Anuruddha
 * Date: 12/16/12
 */
public class LoginTokenManagerImpl implements LoginTokenManager {

    @Autowired
    private LoginTokenDao loginTokenDao;


    @Override
    @Transactional
    public void saveLoginToken(LoginToken loginToken) {
        loginTokenDao.saveLoginToken(loginToken);
    }

    @Override
    @Transactional
    public boolean verifyToken(final Long userId, final String token) throws UserNotFoundException {

        boolean result = false;

        try {
            LoginToken lastToken = loginTokenDao.getLastLoginTokenByUserId(userId);
            if (lastToken != null) {
                if (lastToken.getLoginToken().equals(token)) {
                    Calendar current = Calendar.getInstance();
                    current.add(Calendar.MINUTE, -30);

                    if (!current.getTime().after(lastToken.getTokenCreatedTime())) {
                        result = true;
                    }
                }
            }
        } catch (NoResultException ex) {
            throw new UserNotFoundException("Unable to found user :" + userId);
        }

        return result;
    }

    @Override
    public LoginToken getLastLoginTokenByUserId(final Long userId) {
        return loginTokenDao.getLastLoginTokenByUserId(userId);
    }
}
