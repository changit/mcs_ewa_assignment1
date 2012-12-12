package com.sri;

import com.sri.dao.UserDao;
import com.sri.dao.domain.User;
import com.sri.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowire;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * Created with IntelliJ IDEA.
 * User: chandana
 * Date: 12/12/12
 * Time: 10:41 PM
 * To change this template use File | Settings | File Templates.
 */
public class Test {

    private static Logger logger = LoggerFactory.getLogger(Test.class);

    @Autowired
    UserService userService;

    public void init() {
         User user = new User();
         user.setUserName("XXX");
         userService.createUser(user);

        User foundUser= userService.findUserByUserName("XXX");
        logger.info("Found Entity [{}] ", foundUser.getUserName());

    }
}
