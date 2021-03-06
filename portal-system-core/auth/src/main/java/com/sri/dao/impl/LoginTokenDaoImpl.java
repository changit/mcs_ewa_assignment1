package com.sri.dao.impl;

import com.sri.dao.LoginTokenDao;
import com.sri.model.LoginToken;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 * User: Gihan Anuruddha
 * Date: 12/16/12
 */
public class LoginTokenDaoImpl implements LoginTokenDao {


    private static final String GET_USER_LAST_TOKEN_BY_USER_ID = "SELECT t FROM LoginToken as t WHERE t.userId = :userId ORDER BY t.tokenCreatedTime desc";

    @PersistenceContext
    private EntityManager em;

    @Override
    public void saveLoginToken(LoginToken loginToken) {
        em.persist(loginToken);
    }

    @Override
    public LoginToken getLastLoginTokenByUserId(final Long userId) {
        Query query = em.createQuery(GET_USER_LAST_TOKEN_BY_USER_ID);
        query.setParameter("userId", userId);
        query.setMaxResults(1);

        return (LoginToken) query.getSingleResult();
    }


}
