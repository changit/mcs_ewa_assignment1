package com.sri.service;

import com.sri.model.User;

/**
 * Created with IntelliJ IDEA.
 * User: chandana
 * Date: 12/12/12
 * Time: 10:55 PM
 * To change this template use File | Settings | File Templates.
 */
public interface UserService {

    void createUser(User user);

    User findUserByUserName(String userName);

    void deleteUser(User user);

    void updateUser(User user);
}
