package com.sri.model;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Date;

/**
 * User: Gihan Anuruddha
 * Date: 12/16/12
 */
@Entity
public class LoginToken implements Serializable {

    private static final long serialVersionUID = 6431062624287033179L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Long userId;
    private String loginToken;
    private Date tokenCreatedTime;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getLoginToken() {
        return loginToken;
    }

    public void setLoginToken(String loginToken) {
        this.loginToken = loginToken;
    }

    public Date getTokenCreatedTime() {
        return tokenCreatedTime;
    }

    public void setTokenCreatedTime(Date tokenCreatedTime) {
        this.tokenCreatedTime = tokenCreatedTime;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
    }
}
