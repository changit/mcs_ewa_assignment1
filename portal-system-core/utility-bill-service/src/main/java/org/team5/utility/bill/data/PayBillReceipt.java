package org.team5.utility.bill.data;

/**
 * Created with IntelliJ IDEA.
 * User: chan
 * Date: 1/16/13
 * Time: 10:22 PM
 * To change this template use File | Settings | File Templates.
 */
public class PayBillReceipt {

    private String transactionId;
    private String amount;
    private String accountNo;

    public String getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getAccountNo() {
        return accountNo;
    }

    public void setAccountNo(String accountNo) {
        this.accountNo = accountNo;
    }

    @Override
    public String toString() {
        return "PayBillReceipt{" +
                "transactionId='" + transactionId + '\'' +
                ", amount='" + amount + '\'' +
                ", accountNo='" + accountNo + '\'' +
                '}';
    }
}
