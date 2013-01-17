package org.team5.utility.bill.service.impl;

import com.sribank.org.portal.BankPortalService;
import com.sribank.org.portal.FundTransferCode;
import com.sribank.org.portal.FundTransferRequest;
import com.sribank.org.portal.FundTransferResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.team5.portal.service.impl.BankPortalServiceImplService;
import org.team5.utility.bill.data.*;
import org.team5.utility.bill.service.MerchantConnector;
import org.team5.utility.bill.service.UtilityBillService;

import javax.annotation.Resource;
import javax.jws.WebService;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: chan
 * Date: 12/29/12
 * Time: 10:05 PM
 * To change this template use File | Settings | File Templates.
 */

@WebService(endpointInterface = "org.team5.utility.bill.service.UtilityBillService")
public class UtilityBillServiceImpl implements UtilityBillService {

    private static final Logger logger = LoggerFactory.getLogger(UtilityBillServiceImpl.class);

    private Map<String, Merchant> merchantMap;
    private List<Merchant> merchantList;

    @Resource(name = "merchantConnectorMap")
    private Map<String, MerchantConnector> merchantConnectorMap;

    @Autowired
    private BankPortalService portalService;


    @Override
    public List<Merchant> getMerchantList() {
        return merchantList;
    }

    @Override
    public PayBillResponse pay(PayBillRequest payBillRequest) {

        logger.info("Pay Bill Request Received [{}]", payBillRequest);

        PayBillResponse payBillResponse = new PayBillResponse();
        System.err.println("MErchant mnap" + merchantMap);
        Merchant merchant = (Merchant) merchantMap.get(String.valueOf(payBillRequest.getMerchantId()));
        if(merchant == null) {
            payBillResponse.setDescription("No merchant found. invalid request");
            payBillResponse.setResultCode(PayBillResponseCode.FAILED_0002);
            payBillResponse.setDescription(PayBillResponseCode.FAILED_0002.getDescription());
            return payBillResponse;
        }

        FundTransferRequest transferRequest = new FundTransferRequest();
        transferRequest.setAmount(payBillRequest.getAmount());
        transferRequest.setFromAccount(payBillRequest.getFromAccount());
        transferRequest.setToAccount(merchant.getBankAccount());
        transferRequest.setUserId(payBillRequest.getUserId());
        transferRequest.setLoginToken(payBillRequest.getLoginToken());

        try {
            FundTransferResponse response = portalService.transfer(transferRequest);
            if(response.getResultCode().equals(FundTransferCode.SUCCESS_0000)){
                payBillResponse.setResultCode(PayBillResponseCode.SUCCESS_0000);
                payBillResponse.setDescription("Successfully completed");

                PayBillReceipt payBillReceipt = new PayBillReceipt();
                payBillReceipt.setAccountNo(payBillRequest.getFromAccount());
                payBillReceipt.setAmount(payBillRequest.getAmount());
                payBillReceipt.setTransactionId(response.getTransactionId());

                notifyMerchant(payBillReceipt, merchant);
            } else {
                payBillResponse.setResultCode(PayBillResponseCode.FAILED_0003);
                payBillResponse.setDescription("Failed with error [" +  response.getDescription()+ "]");
            }

        } catch (Exception e) {
            e.printStackTrace();
            payBillResponse.setResultCode(PayBillResponseCode.FAILED_1000);
            payBillResponse.setDescription(PayBillResponseCode.FAILED_1000.getDescription());

        }

        return payBillResponse;
    }

    private void notifyMerchant(PayBillReceipt payBillReceipt, Merchant merchant) {
        try {
            MerchantConnector connector = merchantConnectorMap.get(merchant.getId());
            if(connector == null) {
                logger.error("No merchant connector found to notify");
                return;
            }

            connector.notifyMerchant(payBillReceipt);

        }catch (Exception e) {
            logger.error("Unexpected Error Occurred", e);
        }
    }

    public void setMerchantConnectorMap(Map<String, MerchantConnector> merchantConnectorMap) {
        this.merchantConnectorMap = merchantConnectorMap;
    }

    @Resource(name = "merchentMap")
    public void setMerchantMap(Map<String, Merchant> merchantMap) {
        this.merchantMap = merchantMap;
        merchantList = new ArrayList<Merchant>();
        merchantList.addAll(merchantMap.values());
    }
}
