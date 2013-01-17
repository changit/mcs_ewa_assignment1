
package com.sribank.org.portal;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for creditCardAccount complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="creditCardAccount">
 *   &lt;complexContent>
 *     &lt;extension base="{http://org.sribank.com/portal}account">
 *       &lt;sequence>
 *         &lt;element name="creditLimit" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="expiredData" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="issuedData" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "creditCardAccount", propOrder = {
    "creditLimit",
    "expiredData",
    "issuedData"
})
public class CreditCardAccount
    extends Account
{

    protected String creditLimit;
    protected String expiredData;
    protected String issuedData;

    /**
     * Gets the value of the creditLimit property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCreditLimit() {
        return creditLimit;
    }

    /**
     * Sets the value of the creditLimit property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCreditLimit(String value) {
        this.creditLimit = value;
    }

    /**
     * Gets the value of the expiredData property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getExpiredData() {
        return expiredData;
    }

    /**
     * Sets the value of the expiredData property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setExpiredData(String value) {
        this.expiredData = value;
    }

    /**
     * Gets the value of the issuedData property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIssuedData() {
        return issuedData;
    }

    /**
     * Sets the value of the issuedData property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIssuedData(String value) {
        this.issuedData = value;
    }

}
