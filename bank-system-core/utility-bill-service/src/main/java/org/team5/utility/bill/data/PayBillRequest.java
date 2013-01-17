package org.team5.utility.bill.data;

/**
 * Created with IntelliJ IDEA.
 * User: chan
 * Date: 12/29/12
 * Time: 9:58 PM
 * To change this template use File | Settings | File Templates.
 */
public class PayBillRequest {

    private String requestId;
    private String fromAccount;
    private String merchantId;
    private String amount;
    private Long userId;
    private String loginToken;

    public String getRequestId() {
        return requestId;
    }

    public void setRequestId(String requestId) {
        this.requestId = requestId;
    }

    public String getFromAccount() {
        return fromAccount;
    }

    public void setFromAccount(String fromAccount) {
        this.fromAccount = fromAccount;
    }

    public String getMerchantId() {
        return merchantId;
    }

    public void setMerchantId(String merchantId) {
        this.merchantId = merchantId;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

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

    @Override
    public String toString() {
        return "PayBillRequest{" +
                "requestId='" + requestId + '\'' +
                ", fromAccount='" + fromAccount + '\'' +
                ", merchantId='" + merchantId + '\'' +
                ", amount='" + amount + '\'' +
                ", userId=" + userId +
                ", loginToken='" + loginToken + '\'' +
                '}';
    }
}
