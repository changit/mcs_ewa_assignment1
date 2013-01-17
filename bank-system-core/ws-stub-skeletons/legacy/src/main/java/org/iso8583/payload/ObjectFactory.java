
package org.iso8583.payload;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;
import org.team5.bank.core.server.service.model.xsd.Account;
import org.team5.bank.core.server.service.model.xsd.TransactionResponse;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the org.iso8583.payload package. 
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

    private final static QName _WithdrawAccountNo_QNAME = new QName("http://iso8583.org/payload", "accountNo");
    private final static QName _GetAccountResponseReturn_QNAME = new QName("http://iso8583.org/payload", "return");
    private final static QName _FundTransferFrom_QNAME = new QName("http://iso8583.org/payload", "from");
    private final static QName _FundTransferTo_QNAME = new QName("http://iso8583.org/payload", "to");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: org.iso8583.payload
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link GetAccount }
     * 
     */
    public GetAccount createGetAccount() {
        return new GetAccount();
    }

    /**
     * Create an instance of {@link FundTransferResponse }
     * 
     */
    public FundTransferResponse createFundTransferResponse() {
        return new FundTransferResponse();
    }

    /**
     * Create an instance of {@link GetAccountResponse }
     * 
     */
    public GetAccountResponse createGetAccountResponse() {
        return new GetAccountResponse();
    }

    /**
     * Create an instance of {@link Withdraw }
     * 
     */
    public Withdraw createWithdraw() {
        return new Withdraw();
    }

    /**
     * Create an instance of {@link GetBalanceResponse }
     * 
     */
    public GetBalanceResponse createGetBalanceResponse() {
        return new GetBalanceResponse();
    }

    /**
     * Create an instance of {@link GetTransactionHistory }
     * 
     */
    public GetTransactionHistory createGetTransactionHistory() {
        return new GetTransactionHistory();
    }

    /**
     * Create an instance of {@link WithdrawResponse }
     * 
     */
    public WithdrawResponse createWithdrawResponse() {
        return new WithdrawResponse();
    }

    /**
     * Create an instance of {@link GetTransactionHistoryResponse }
     * 
     */
    public GetTransactionHistoryResponse createGetTransactionHistoryResponse() {
        return new GetTransactionHistoryResponse();
    }

    /**
     * Create an instance of {@link Deposit }
     * 
     */
    public Deposit createDeposit() {
        return new Deposit();
    }

    /**
     * Create an instance of {@link FundTransfer }
     * 
     */
    public FundTransfer createFundTransfer() {
        return new FundTransfer();
    }

    /**
     * Create an instance of {@link DepositResponse }
     * 
     */
    public DepositResponse createDepositResponse() {
        return new DepositResponse();
    }

    /**
     * Create an instance of {@link GetBalance }
     * 
     */
    public GetBalance createGetBalance() {
        return new GetBalance();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://iso8583.org/payload", name = "accountNo", scope = Withdraw.class)
    public JAXBElement<String> createWithdrawAccountNo(String value) {
        return new JAXBElement<String>(_WithdrawAccountNo_QNAME, String.class, Withdraw.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Account }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://iso8583.org/payload", name = "return", scope = GetAccountResponse.class)
    public JAXBElement<Account> createGetAccountResponseReturn(Account value) {
        return new JAXBElement<Account>(_GetAccountResponseReturn_QNAME, Account.class, GetAccountResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TransactionResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://iso8583.org/payload", name = "return", scope = FundTransferResponse.class)
    public JAXBElement<TransactionResponse> createFundTransferResponseReturn(TransactionResponse value) {
        return new JAXBElement<TransactionResponse>(_GetAccountResponseReturn_QNAME, TransactionResponse.class, FundTransferResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://iso8583.org/payload", name = "return", scope = GetBalanceResponse.class)
    public JAXBElement<String> createGetBalanceResponseReturn(String value) {
        return new JAXBElement<String>(_GetAccountResponseReturn_QNAME, String.class, GetBalanceResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://iso8583.org/payload", name = "accountNo", scope = GetTransactionHistory.class)
    public JAXBElement<String> createGetTransactionHistoryAccountNo(String value) {
        return new JAXBElement<String>(_WithdrawAccountNo_QNAME, String.class, GetTransactionHistory.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TransactionResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://iso8583.org/payload", name = "return", scope = WithdrawResponse.class)
    public JAXBElement<TransactionResponse> createWithdrawResponseReturn(TransactionResponse value) {
        return new JAXBElement<TransactionResponse>(_GetAccountResponseReturn_QNAME, TransactionResponse.class, WithdrawResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://iso8583.org/payload", name = "accountNo", scope = Deposit.class)
    public JAXBElement<String> createDepositAccountNo(String value) {
        return new JAXBElement<String>(_WithdrawAccountNo_QNAME, String.class, Deposit.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://iso8583.org/payload", name = "from", scope = FundTransfer.class)
    public JAXBElement<String> createFundTransferFrom(String value) {
        return new JAXBElement<String>(_FundTransferFrom_QNAME, String.class, FundTransfer.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://iso8583.org/payload", name = "to", scope = FundTransfer.class)
    public JAXBElement<String> createFundTransferTo(String value) {
        return new JAXBElement<String>(_FundTransferTo_QNAME, String.class, FundTransfer.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TransactionResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://iso8583.org/payload", name = "return", scope = DepositResponse.class)
    public JAXBElement<TransactionResponse> createDepositResponseReturn(TransactionResponse value) {
        return new JAXBElement<TransactionResponse>(_GetAccountResponseReturn_QNAME, TransactionResponse.class, DepositResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://iso8583.org/payload", name = "accountNo", scope = GetBalance.class)
    public JAXBElement<String> createGetBalanceAccountNo(String value) {
        return new JAXBElement<String>(_WithdrawAccountNo_QNAME, String.class, GetBalance.class, value);
    }

}
