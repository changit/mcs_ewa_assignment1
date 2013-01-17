
package com.sribank.org.portal;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.sribank.org.portal package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _GetCreditCardListResponse_QNAME = new QName("http://org.sribank.com/portal", "getCreditCardListResponse");
    private final static QName _GetCreditCardTransactionByCardIdResponse_QNAME = new QName("http://org.sribank.com/portal", "getCreditCardTransactionByCardIdResponse");
    private final static QName _GetAccountListResponse_QNAME = new QName("http://org.sribank.com/portal", "getAccountListResponse");
    private final static QName _GetAccountHistoryResponse_QNAME = new QName("http://org.sribank.com/portal", "getAccountHistoryResponse");
    private final static QName _GetAccountList_QNAME = new QName("http://org.sribank.com/portal", "getAccountList");
    private final static QName _Transfer_QNAME = new QName("http://org.sribank.com/portal", "transfer");
    private final static QName _TransferResponse_QNAME = new QName("http://org.sribank.com/portal", "transferResponse");
    private final static QName _GetCreditCardList_QNAME = new QName("http://org.sribank.com/portal", "getCreditCardList");
    private final static QName _GetCreditCardTransactionByCardId_QNAME = new QName("http://org.sribank.com/portal", "getCreditCardTransactionByCardId");
    private final static QName _GetAccountHistory_QNAME = new QName("http://org.sribank.com/portal", "getAccountHistory");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.sribank.org.portal
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link Transaction }
     * 
     */
    public Transaction createTransaction() {
        return new Transaction();
    }

    /**
     * Create an instance of {@link Account }
     * 
     */
    public Account createAccount() {
        return new Account();
    }

    /**
     * Create an instance of {@link GetCreditCardTransactionByCardId }
     * 
     */
    public GetCreditCardTransactionByCardId createGetCreditCardTransactionByCardId() {
        return new GetCreditCardTransactionByCardId();
    }

    /**
     * Create an instance of {@link GetAccountList }
     * 
     */
    public GetAccountList createGetAccountList() {
        return new GetAccountList();
    }

    /**
     * Create an instance of {@link GetAccountHistoryResponse }
     * 
     */
    public GetAccountHistoryResponse createGetAccountHistoryResponse() {
        return new GetAccountHistoryResponse();
    }

    /**
     * Create an instance of {@link GetCreditCardListResponse }
     * 
     */
    public GetCreditCardListResponse createGetCreditCardListResponse() {
        return new GetCreditCardListResponse();
    }

    /**
     * Create an instance of {@link FundTransferResponse }
     * 
     */
    public FundTransferResponse createFundTransferResponse() {
        return new FundTransferResponse();
    }

    /**
     * Create an instance of {@link GetCreditCardList }
     * 
     */
    public GetCreditCardList createGetCreditCardList() {
        return new GetCreditCardList();
    }

    /**
     * Create an instance of {@link TransferResponse }
     * 
     */
    public TransferResponse createTransferResponse() {
        return new TransferResponse();
    }

    /**
     * Create an instance of {@link GetAccountListResponse }
     * 
     */
    public GetAccountListResponse createGetAccountListResponse() {
        return new GetAccountListResponse();
    }

    /**
     * Create an instance of {@link GetCreditCardTransactionByCardIdResponse }
     * 
     */
    public GetCreditCardTransactionByCardIdResponse createGetCreditCardTransactionByCardIdResponse() {
        return new GetCreditCardTransactionByCardIdResponse();
    }

    /**
     * Create an instance of {@link FundTransferRequest }
     * 
     */
    public FundTransferRequest createFundTransferRequest() {
        return new FundTransferRequest();
    }

    /**
     * Create an instance of {@link Transfer }
     * 
     */
    public Transfer createTransfer() {
        return new Transfer();
    }

    /**
     * Create an instance of {@link GetAccountHistory }
     * 
     */
    public GetAccountHistory createGetAccountHistory() {
        return new GetAccountHistory();
    }

    /**
     * Create an instance of {@link CreditCardAccount }
     * 
     */
    public CreditCardAccount createCreditCardAccount() {
        return new CreditCardAccount();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetCreditCardListResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://org.sribank.com/portal", name = "getCreditCardListResponse")
    public JAXBElement<GetCreditCardListResponse> createGetCreditCardListResponse(GetCreditCardListResponse value) {
        return new JAXBElement<GetCreditCardListResponse>(_GetCreditCardListResponse_QNAME, GetCreditCardListResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetCreditCardTransactionByCardIdResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://org.sribank.com/portal", name = "getCreditCardTransactionByCardIdResponse")
    public JAXBElement<GetCreditCardTransactionByCardIdResponse> createGetCreditCardTransactionByCardIdResponse(GetCreditCardTransactionByCardIdResponse value) {
        return new JAXBElement<GetCreditCardTransactionByCardIdResponse>(_GetCreditCardTransactionByCardIdResponse_QNAME, GetCreditCardTransactionByCardIdResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetAccountListResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://org.sribank.com/portal", name = "getAccountListResponse")
    public JAXBElement<GetAccountListResponse> createGetAccountListResponse(GetAccountListResponse value) {
        return new JAXBElement<GetAccountListResponse>(_GetAccountListResponse_QNAME, GetAccountListResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetAccountHistoryResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://org.sribank.com/portal", name = "getAccountHistoryResponse")
    public JAXBElement<GetAccountHistoryResponse> createGetAccountHistoryResponse(GetAccountHistoryResponse value) {
        return new JAXBElement<GetAccountHistoryResponse>(_GetAccountHistoryResponse_QNAME, GetAccountHistoryResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetAccountList }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://org.sribank.com/portal", name = "getAccountList")
    public JAXBElement<GetAccountList> createGetAccountList(GetAccountList value) {
        return new JAXBElement<GetAccountList>(_GetAccountList_QNAME, GetAccountList.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Transfer }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://org.sribank.com/portal", name = "transfer")
    public JAXBElement<Transfer> createTransfer(Transfer value) {
        return new JAXBElement<Transfer>(_Transfer_QNAME, Transfer.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TransferResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://org.sribank.com/portal", name = "transferResponse")
    public JAXBElement<TransferResponse> createTransferResponse(TransferResponse value) {
        return new JAXBElement<TransferResponse>(_TransferResponse_QNAME, TransferResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetCreditCardList }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://org.sribank.com/portal", name = "getCreditCardList")
    public JAXBElement<GetCreditCardList> createGetCreditCardList(GetCreditCardList value) {
        return new JAXBElement<GetCreditCardList>(_GetCreditCardList_QNAME, GetCreditCardList.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetCreditCardTransactionByCardId }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://org.sribank.com/portal", name = "getCreditCardTransactionByCardId")
    public JAXBElement<GetCreditCardTransactionByCardId> createGetCreditCardTransactionByCardId(GetCreditCardTransactionByCardId value) {
        return new JAXBElement<GetCreditCardTransactionByCardId>(_GetCreditCardTransactionByCardId_QNAME, GetCreditCardTransactionByCardId.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetAccountHistory }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://org.sribank.com/portal", name = "getAccountHistory")
    public JAXBElement<GetAccountHistory> createGetAccountHistory(GetAccountHistory value) {
        return new JAXBElement<GetAccountHistory>(_GetAccountHistory_QNAME, GetAccountHistory.class, null, value);
    }

}
