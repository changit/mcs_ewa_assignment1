package dialog.gsm;

/**
 * Created with IntelliJ IDEA.
 * User: chan
 * Date: 1/17/13
 * Time: 10:50 PM
 * To change this template use File | Settings | File Templates.
 */
public class BillReceipt {

    private String amount;
    private String accountNo;
    private String dateTime;

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

    public String getDateTime() {
        return dateTime;
    }

    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
    }

    @Override
    public String toString() {
        return "BillReceipt{" +
                "amount='" + amount + '\'' +
                ", accountNo='" + accountNo + '\'' +
                ", dateTime='" + dateTime + '\'' +
                '}';
    }
}
