package com.sri.model;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * Created with IntelliJ IDEA.
 * User: chandana
 * Date: 12/12/12
 * Time: 10:01 PM
 * To change this template use File | Settings | File Templates.
 */

@Entity
public class User implements Serializable{

    private static final long serialVersionUID = 1766011896418846627L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(unique = true, length = 50)
    private String userName;
    @Column(length = 50)
    private String password;
    private boolean accountLock;
    private int invalidPasswordCount;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "user_role",
            joinColumns = { @JoinColumn(name = "user_id") },
            inverseJoinColumns = @JoinColumn(name = "role_id")
    )
    private Set<Role> roles = new HashSet<Role>();

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

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    public boolean isAccountLock() {
        return accountLock;
    }

    public void setAccountLock(boolean accountLock) {
        this.accountLock = accountLock;
    }

    public int getInvalidPasswordCount() {
        return invalidPasswordCount;
    }

    public void setInvalidPasswordCount(int invalidPasswordCount) {
        this.invalidPasswordCount = invalidPasswordCount;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
    }
}
