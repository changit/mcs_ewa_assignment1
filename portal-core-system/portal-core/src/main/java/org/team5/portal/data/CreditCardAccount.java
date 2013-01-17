package org.team5.portal.data;

import java.io.Serializable;

/**
 * Created with IntelliJ IDEA.
 * User: gihan
 * Date: 12/30/12
 * Time: 2:52 PM
 * To change this template use File | Settings | File Templates.
 */
public class CreditCardAccount extends Account {

    private static final long serialVersionUID = -3390174807659673874L;

    private String issuedData;
    private String expiredData;
    private String creditLimit;

    public String getIssuedData() {
        return issuedData;
    }

    public void setIssuedData(String issuedData) {
        this.issuedData = issuedData;
    }

    public String getExpiredData() {
        return expiredData;
    }

    public void setExpiredData(String expiredData) {
        this.expiredData = expiredData;
    }

    public String getCreditLimit() {
        return creditLimit;
    }

    public void setCreditLimit(String creditLimit) {
        this.creditLimit = creditLimit;
    }
}
