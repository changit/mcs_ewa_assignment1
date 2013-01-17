package org.team5.utility.bill.data;

/**
 * Created with IntelliJ IDEA.
 * User: chan
 * Date: 12/29/12
 * Time: 10:02 PM
 * To change this template use File | Settings | File Templates.
 */
public enum PayBillResponseCode {

    SUCCESS_0000("Success"),
    FAILED_0000("Failed"),
    FAILED_0001("Insufficient Balance"),
    FAILED_0002("Merchant Not found"),
    FAILED_0003("Unknown Error"),
    FAILED_1000("SystemError");

    private PayBillResponseCode(String description){
        this.description = description;
    }

    private String description;

    public String getDescription(){
        return description;
    }
}
