package com.sri.service.exception;

/**
 * User: Gihan Anuruddha
 * Date: 12/16/12
 */
public class UserNotFoundException extends Exception {
    private static final long serialVersionUID = -5500026764167842266L;

    public UserNotFoundException() {
        super();
    }

    public UserNotFoundException(String message) {
        super(message);
    }
}
