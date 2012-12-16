package com.sri.dao;

import com.sri.model.User;

/**
 * Created with IntelliJ IDEA.
 * User: chandana
 * Date: 12/12/12
 * Time: 10:01 PM
 * To change this template use File | Settings | File Templates.
 */
public interface UserDao {

    void createUser(User user);

    User findUserByUserName(String userName);

    void removeUser(User user);
}
