package com.sri.service;

import com.sri.dao.domain.User;
import org.springframework.beans.factory.annotation.Autowired;

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
}
