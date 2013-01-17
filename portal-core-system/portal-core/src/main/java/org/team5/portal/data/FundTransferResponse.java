package org.team5.portal.data;

/**
 * Created with IntelliJ IDEA.
 * User: chan
 * Date: 12/29/12
 * Time: 8:38 PM
 * To change this template use File | Settings | File Templates.
 */
public class FundTransferResponse {
    private String sourceId;
    private String transactionId;
    private String description;
    private FundTransferCode resultCode;

    public String getSourceId() {
        return sourceId;
    }

    public void setSourceId(String sourceId) {
        this.sourceId = sourceId;
    }

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

    public FundTransferCode getResultCode() {
        return resultCode;
    }

    public void setResultCode(FundTransferCode resultCode) {
        this.resultCode = resultCode;
    }
}
