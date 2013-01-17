package com.sri.service;

import com.sri.model.UserDTO;

import javax.jws.WebParam;
import javax.jws.WebService;
import javax.persistence.NoResultException;

/**
 * Created with IntelliJ IDEA.
 * User: chandana
 * Date: 12/12/12
 * Time: 10:55 PM
 * To change this template use File | Settings | File Templates.
 */

@WebService(targetNamespace = "http://localhost:8080/bank-system-core-user")
public interface UserService {

    UserDTO getUserById(@WebParam(name = "userId")Long userId) throws NoResultException;
}
