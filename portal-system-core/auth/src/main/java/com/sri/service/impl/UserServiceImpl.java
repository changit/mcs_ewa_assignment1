package com.sri.service.impl;

import com.sri.dao.UserDao;
import com.sri.model.User;
import com.sri.model.UserDTO;
import com.sri.service.UserManager;
import com.sri.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.NoResultException;

/**
 * Created with IntelliJ IDEA.
 * User: chandana
 * Date: 12/12/12
 * Time: 10:57 PM
 * To change this template use File | Settings | File Templates.
 */
public class UserServiceImpl implements UserService, UserManager {

    @Autowired
    private UserDao userDao;

    @Override
    @Transactional
    public void createUser(User user) {
        userDao.createUser(user);
    }

    @Override
    public User findUserByUserName(String userName) {
        return userDao.findUserByUserName(userName);
    }

    @Override
    @Transactional
    public void deleteUser(User user) {
        userDao.removeUser(user);
    }

    @Override
    public void updateUser(User user) {
        userDao.updateUser(user);
    }

    @Override
    public UserDTO getUserById(Long userId) throws NoResultException {

        User user = userDao.getUserById(userId);
        UserDTO userDTO = new UserDTO();
        if (user != null) {
            userDTO.setId(user.getId());
            userDTO.setUserName(user.getUserName());
            userDTO.setPassword(user.getPassword());
            userDTO.setTransactionPassword(user.getTransactionPassword());
        }

        return userDTO;
    }
}
