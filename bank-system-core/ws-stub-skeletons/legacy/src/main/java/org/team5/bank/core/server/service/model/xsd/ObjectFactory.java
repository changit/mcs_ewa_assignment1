
package org.team5.bank.core.server.service.model.xsd;

import java.util.Date;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import javax.xml.namespace.QName;
import org.w3._2001.xmlschema.Adapter1;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the org.team5.bank.core.server.service.model.xsd package. 
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

    private final static QName _TransactionResponseTransactionID_QNAME = new QName("http://model.service.server.core.bank.team5.org/xsd", "transactionID");
    private final static QName _TransactionResponseError_QNAME = new QName("http://model.service.server.core.bank.team5.org/xsd", "error");
    private final static QName _TransactionResponseStatus_QNAME = new QName("http://model.service.server.core.bank.team5.org/xsd", "status");
    private final static QName _AccountAccountNo_QNAME = new QName("http://model.service.server.core.bank.team5.org/xsd", "accountNo");
    private final static QName _AccountDescription_QNAME = new QName("http://model.service.server.core.bank.team5.org/xsd", "description");
    private final static QName _AccountId_QNAME = new QName("http://model.service.server.core.bank.team5.org/xsd", "id");
    private final static QName _TransactionType_QNAME = new QName("http://model.service.server.core.bank.team5.org/xsd", "type");
    private final static QName _TransactionFromAccount_QNAME = new QName("http://model.service.server.core.bank.team5.org/xsd", "fromAccount");
    private final static QName _TransactionToAccount_QNAME = new QName("http://model.service.server.core.bank.team5.org/xsd", "toAccount");
    private final static QName _TransactionTimeStamp_QNAME = new QName("http://model.service.server.core.bank.team5.org/xsd", "timeStamp");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: org.team5.bank.core.server.service.model.xsd
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link TransactionResponse }
     * 
     */
    public TransactionResponse createTransactionResponse() {
        return new TransactionResponse();
    }

    /**
     * Create an instance of {@link Account }
     * 
     */
    public Account createAccount() {
        return new Account();
    }

    /**
     * Create an instance of {@link Transaction }
     * 
     */
    public Transaction createTransaction() {
        return new Transaction();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Double }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://model.service.server.core.bank.team5.org/xsd", name = "transactionID", scope = TransactionResponse.class)
    public JAXBElement<Double> createTransactionResponseTransactionID(Double value) {
        return new JAXBElement<Double>(_TransactionResponseTransactionID_QNAME, Double.class, TransactionResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://model.service.server.core.bank.team5.org/xsd", name = "error", scope = TransactionResponse.class)
    public JAXBElement<String> createTransactionResponseError(String value) {
        return new JAXBElement<String>(_TransactionResponseError_QNAME, String.class, TransactionResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://model.service.server.core.bank.team5.org/xsd", name = "status", scope = TransactionResponse.class)
    public JAXBElement<String> createTransactionResponseStatus(String value) {
        return new JAXBElement<String>(_TransactionResponseStatus_QNAME, String.class, TransactionResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://model.service.server.core.bank.team5.org/xsd", name = "accountNo", scope = Account.class)
    public JAXBElement<String> createAccountAccountNo(String value) {
        return new JAXBElement<String>(_AccountAccountNo_QNAME, String.class, Account.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://model.service.server.core.bank.team5.org/xsd", name = "description", scope = Account.class)
    public JAXBElement<String> createAccountDescription(String value) {
        return new JAXBElement<String>(_AccountDescription_QNAME, String.class, Account.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Long }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://model.service.server.core.bank.team5.org/xsd", name = "id", scope = Account.class)
    public JAXBElement<Long> createAccountId(Long value) {
        return new JAXBElement<Long>(_AccountId_QNAME, Long.class, Account.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://model.service.server.core.bank.team5.org/xsd", name = "type", scope = Transaction.class)
    public JAXBElement<String> createTransactionType(String value) {
        return new JAXBElement<String>(_TransactionType_QNAME, String.class, Transaction.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://model.service.server.core.bank.team5.org/xsd", name = "fromAccount", scope = Transaction.class)
    public JAXBElement<String> createTransactionFromAccount(String value) {
        return new JAXBElement<String>(_TransactionFromAccount_QNAME, String.class, Transaction.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://model.service.server.core.bank.team5.org/xsd", name = "toAccount", scope = Transaction.class)
    public JAXBElement<String> createTransactionToAccount(String value) {
        return new JAXBElement<String>(_TransactionToAccount_QNAME, String.class, Transaction.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Date }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://model.service.server.core.bank.team5.org/xsd", name = "timeStamp", scope = Transaction.class)
    @XmlJavaTypeAdapter(Adapter1 .class)
    public JAXBElement<Date> createTransactionTimeStamp(Date value) {
        return new JAXBElement<Date>(_TransactionTimeStamp_QNAME, Date.class, Transaction.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Long }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://model.service.server.core.bank.team5.org/xsd", name = "id", scope = Transaction.class)
    public JAXBElement<Long> createTransactionId(Long value) {
        return new JAXBElement<Long>(_AccountId_QNAME, Long.class, Transaction.class, value);
    }

}
