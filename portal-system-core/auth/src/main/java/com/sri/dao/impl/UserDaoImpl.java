package com.sri.dao.impl;

import com.sri.dao.UserDao;
import com.sri.model.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 * Created with IntelliJ IDEA.
 * User: chandana
 * Date: 12/12/12
 * Time: 10:02 PM
 * To change this template use File | Settings | File Templates.
 */
public class UserDaoImpl implements UserDao {

    private static final String selectUserByUserNameQuery =  "select u from User as u where u.userName = :userName";
    private static final String selectUserByIdNameQuery =  "select u from User as u where u.id = :id";

    @PersistenceContext
    EntityManager em;


    @Override
    public void createUser(User user) {
        em.persist(user);
    }

    @Override
    public User findUserByUserName(String userName) {
        Query query = em.createQuery(selectUserByUserNameQuery);
        query.setParameter("userName", userName);
        return (User) query.getSingleResult();
    }

    @Override
    public void removeUser(User user) {
        em.remove(user);
    }

    @Override
    public void updateUser(User user) {
        em.merge(user);
    }

    @Override
    public User getUserById(Long userId) {
        Query query = em.createQuery(selectUserByIdNameQuery);
        query.setParameter("id", userId);
        return (User) query.getSingleResult();
    }
}
