
package com.dialog.org.billing;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.dialog.org.billing package. 
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

    private final static QName _BillPaid_QNAME = new QName("http://org.dialog.com/billing", "billPaid");
    private final static QName _BillPaidResponse_QNAME = new QName("http://org.dialog.com/billing", "billPaidResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.dialog.org.billing
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link BillPaidResponse }
     * 
     */
    public BillPaidResponse createBillPaidResponse() {
        return new BillPaidResponse();
    }

    /**
     * Create an instance of {@link BillPaid }
     * 
     */
    public BillPaid createBillPaid() {
        return new BillPaid();
    }

    /**
     * Create an instance of {@link BillReceipt }
     * 
     */
    public BillReceipt createBillReceipt() {
        return new BillReceipt();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BillPaid }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://org.dialog.com/billing", name = "billPaid")
    public JAXBElement<BillPaid> createBillPaid(BillPaid value) {
        return new JAXBElement<BillPaid>(_BillPaid_QNAME, BillPaid.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BillPaidResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://org.dialog.com/billing", name = "billPaidResponse")
    public JAXBElement<BillPaidResponse> createBillPaidResponse(BillPaidResponse value) {
        return new JAXBElement<BillPaidResponse>(_BillPaidResponse_QNAME, BillPaidResponse.class, null, value);
    }

}
