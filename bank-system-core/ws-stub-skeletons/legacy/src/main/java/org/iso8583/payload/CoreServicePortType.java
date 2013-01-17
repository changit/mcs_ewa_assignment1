package org.iso8583.payload;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.Action;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;

/**
 * This class was generated by Apache CXF 2.6.1
 * 2013-01-18T00:29:51.310+05:30
 * Generated source version: 2.6.1
 * 
 */
@WebService(targetNamespace = "http://iso8583.org/payload", name = "CoreServicePortType")
@XmlSeeAlso({ObjectFactory.class, org.team5.bank.core.server.service.model.xsd.ObjectFactory.class})
public interface CoreServicePortType {

    @WebResult(name = "return", targetNamespace = "http://iso8583.org/payload")
    @Action(input = "urn:getTransactionHistory", output = "urn:getTransactionHistoryResponse")
    @RequestWrapper(localName = "getTransactionHistory", targetNamespace = "http://iso8583.org/payload", className = "org.iso8583.payload.GetTransactionHistory")
    @WebMethod(action = "urn:getTransactionHistory")
    @ResponseWrapper(localName = "getTransactionHistoryResponse", targetNamespace = "http://iso8583.org/payload", className = "org.iso8583.payload.GetTransactionHistoryResponse")
    public java.util.List<org.team5.bank.core.server.service.model.xsd.Transaction> getTransactionHistory(
        @WebParam(name = "accountNo", targetNamespace = "http://iso8583.org/payload")
        java.lang.String accountNo
    );

    @WebResult(name = "return", targetNamespace = "http://iso8583.org/payload")
    @Action(input = "urn:getBalance", output = "urn:getBalanceResponse")
    @RequestWrapper(localName = "getBalance", targetNamespace = "http://iso8583.org/payload", className = "org.iso8583.payload.GetBalance")
    @WebMethod(action = "urn:getBalance")
    @ResponseWrapper(localName = "getBalanceResponse", targetNamespace = "http://iso8583.org/payload", className = "org.iso8583.payload.GetBalanceResponse")
    public java.lang.String getBalance(
        @WebParam(name = "accountNo", targetNamespace = "http://iso8583.org/payload")
        java.lang.String accountNo
    );

    @WebResult(name = "return", targetNamespace = "http://iso8583.org/payload")
    @Action(input = "urn:getAccount", output = "urn:getAccountResponse")
    @RequestWrapper(localName = "getAccount", targetNamespace = "http://iso8583.org/payload", className = "org.iso8583.payload.GetAccount")
    @WebMethod(action = "urn:getAccount")
    @ResponseWrapper(localName = "getAccountResponse", targetNamespace = "http://iso8583.org/payload", className = "org.iso8583.payload.GetAccountResponse")
    public org.team5.bank.core.server.service.model.xsd.Account getAccount(
        @WebParam(name = "userId", targetNamespace = "http://iso8583.org/payload")
        java.lang.Long userId
    );

    @WebResult(name = "return", targetNamespace = "http://iso8583.org/payload")
    @Action(input = "urn:withdraw", output = "urn:withdrawResponse")
    @RequestWrapper(localName = "withdraw", targetNamespace = "http://iso8583.org/payload", className = "org.iso8583.payload.Withdraw")
    @WebMethod(action = "urn:withdraw")
    @ResponseWrapper(localName = "withdrawResponse", targetNamespace = "http://iso8583.org/payload", className = "org.iso8583.payload.WithdrawResponse")
    public org.team5.bank.core.server.service.model.xsd.TransactionResponse withdraw(
        @WebParam(name = "accountNo", targetNamespace = "http://iso8583.org/payload")
        java.lang.String accountNo,
        @WebParam(name = "amount", targetNamespace = "http://iso8583.org/payload")
        java.lang.Double amount
    );

    @WebResult(name = "return", targetNamespace = "http://iso8583.org/payload")
    @Action(input = "urn:fundTransfer", output = "urn:fundTransferResponse")
    @RequestWrapper(localName = "fundTransfer", targetNamespace = "http://iso8583.org/payload", className = "org.iso8583.payload.FundTransfer")
    @WebMethod(action = "urn:fundTransfer")
    @ResponseWrapper(localName = "fundTransferResponse", targetNamespace = "http://iso8583.org/payload", className = "org.iso8583.payload.FundTransferResponse")
    public org.team5.bank.core.server.service.model.xsd.TransactionResponse fundTransfer(
        @WebParam(name = "from", targetNamespace = "http://iso8583.org/payload")
        java.lang.String from,
        @WebParam(name = "to", targetNamespace = "http://iso8583.org/payload")
        java.lang.String to,
        @WebParam(name = "amount", targetNamespace = "http://iso8583.org/payload")
        java.lang.Double amount
    );

    @WebResult(name = "return", targetNamespace = "http://iso8583.org/payload")
    @Action(input = "urn:deposit", output = "urn:depositResponse")
    @RequestWrapper(localName = "deposit", targetNamespace = "http://iso8583.org/payload", className = "org.iso8583.payload.Deposit")
    @WebMethod(action = "urn:deposit")
    @ResponseWrapper(localName = "depositResponse", targetNamespace = "http://iso8583.org/payload", className = "org.iso8583.payload.DepositResponse")
    public org.team5.bank.core.server.service.model.xsd.TransactionResponse deposit(
        @WebParam(name = "accountNo", targetNamespace = "http://iso8583.org/payload")
        java.lang.String accountNo,
        @WebParam(name = "amount", targetNamespace = "http://iso8583.org/payload")
        java.lang.Double amount
    );
}
