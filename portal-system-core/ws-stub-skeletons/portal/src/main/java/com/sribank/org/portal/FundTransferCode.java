
package com.sribank.org.portal;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for fundTransferCode.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="fundTransferCode">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="SUCCESS_0000"/>
 *     &lt;enumeration value="FAILED_0001"/>
 *     &lt;enumeration value="FAILED_0002"/>
 *     &lt;enumeration value="FAILED_0003"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "fundTransferCode")
@XmlEnum
public enum FundTransferCode {

    SUCCESS_0000,
    FAILED_0001,
    FAILED_0002,
    FAILED_0003;

    public String value() {
        return name();
    }

    public static FundTransferCode fromValue(String v) {
        return valueOf(v);
    }

}
