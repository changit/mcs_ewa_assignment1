package com.sri.service;

import com.sri.model.User;

/**
 * Created with IntelliJ IDEA.
 * User: gihan
 * Date: 12/30/12
 * Time: 9:32 AM
 * To change this template use File | Settings | File Templates.
 */
public interface UserManager {

    void createUser(User user);

    User findUserByUserName(String userName);

    void deleteUser(User user);

    void updateUser(User user);
}
