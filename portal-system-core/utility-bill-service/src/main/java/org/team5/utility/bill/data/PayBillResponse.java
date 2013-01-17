package org.team5.utility.bill.data;

/**
 * Created with IntelliJ IDEA.
 * User: chan
 * Date: 12/29/12
 * Time: 9:58 PM
 * To change this template use File | Settings | File Templates.
 */
public class PayBillResponse {
    private String transactionId;
    private String description;
    private PayBillResponseCode resultCode;

    public String getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public PayBillResponseCode getResultCode() {
        return resultCode;
    }

    public void setResultCode(PayBillResponseCode resultCode) {
        this.resultCode = resultCode;
    }
}
