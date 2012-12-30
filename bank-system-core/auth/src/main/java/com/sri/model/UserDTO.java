package com.sri.model;

import java.io.Serializable;

/**
 * Created with IntelliJ IDEA.
 * User: gihan
 * Date: 12/30/12
 * Time: 10:24 AM
 * To change this template use File | Settings | File Templates.
 */
public class UserDTO  implements Serializable{

    private static final long serialVersionUID = -5500815956565334868L;

    private Long id;
    private String userName;
    private String password;
    private String transactionPassword;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getTransactionPassword() {
        return transactionPassword;
    }

    public void setTransactionPassword(String transactionPassword) {
        this.transactionPassword = transactionPassword;
    }
}
