
package org.team5.bank.core.server.service.model.xsd;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.datatype.XMLGregorianCalendar;
import javax.xml.namespace.QName;


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

    private final static QName _TransactionType_QNAME = new QName("http://model.service.server.core.bank.team5.org/xsd", "type");
    private final static QName _TransactionFromAccount_QNAME = new QName("http://model.service.server.core.bank.team5.org/xsd", "fromAccount");
    private final static QName _TransactionToAccount_QNAME = new QName("http://model.service.server.core.bank.team5.org/xsd", "toAccount");
    private final static QName _TransactionTimeStamp_QNAME = new QName("http://model.service.server.core.bank.team5.org/xsd", "timeStamp");
    private final static QName _TransactionId_QNAME = new QName("http://model.service.server.core.bank.team5.org/xsd", "id");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: org.team5.bank.core.server.service.model.xsd
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
     * Create an instance of {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://model.service.server.core.bank.team5.org/xsd", name = "timeStamp", scope = Transaction.class)
    public JAXBElement<XMLGregorianCalendar> createTransactionTimeStamp(XMLGregorianCalendar value) {
        return new JAXBElement<XMLGregorianCalendar>(_TransactionTimeStamp_QNAME, XMLGregorianCalendar.class, Transaction.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Long }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://model.service.server.core.bank.team5.org/xsd", name = "id", scope = Transaction.class)
    public JAXBElement<Long> createTransactionId(Long value) {
        return new JAXBElement<Long>(_TransactionId_QNAME, Long.class, Transaction.class, value);
    }

}
