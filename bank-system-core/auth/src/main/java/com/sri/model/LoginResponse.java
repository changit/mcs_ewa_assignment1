package com.sri.model;

import java.io.Serializable;

/**
 * User: Gihan Anuruddha
 * Date: 12/12/12
 */
public class LoginResponse implements Serializable {

    private static final long serialVersionUID = -5117289457680348122L;

    private String userId;
    private String loginToken;
    private String[] roles;
    private String result;

    public LoginResponse() {
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getLoginToken() {
        return loginToken;
    }

    public void setLoginToken(String loginToken) {
        this.loginToken = loginToken;
    }

    public String[] getRoles() {
        return roles;
    }

    public void setRoles(String[] roles) {
        this.roles = roles;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    @Override
    public String toString() {
        return "LoginResponse{UserId:" + userId + ", LoginToken:" + loginToken + ", Result:" + result + "}";
    }
}
