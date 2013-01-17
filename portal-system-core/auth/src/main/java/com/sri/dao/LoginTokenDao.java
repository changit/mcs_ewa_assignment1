package com.sri.dao;

import com.sri.model.LoginToken;

import javax.persistence.NoResultException;

/**
 * User: Gihan Anuruddha
 * Date: 12/16/12
 */
public interface LoginTokenDao {

    void saveLoginToken(LoginToken loginToken);

    LoginToken getLastLoginTokenByUserId(Long userId);
}
