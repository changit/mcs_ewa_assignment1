package org.team5.utility.bill.service.impl;

import org.team5.utility.bill.data.Merchant;
import org.team5.utility.bill.data.PayBillRequest;
import org.team5.utility.bill.data.PayBillResponse;
import org.team5.utility.bill.data.PayBillResponseCode;
import org.team5.utility.bill.service.UtilityBillService;

import javax.jws.WebService;
import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: chan
 * Date: 12/29/12
 * Time: 10:05 PM
 * To change this template use File | Settings | File Templates.
 */

@WebService(endpointInterface = "org.team5.utility.bill.service.UtilityBillService")
public class UtilityBillServiceImpl implements UtilityBillService {

    @Override
    public List<Merchant> getMerchantList() {
        final  Merchant dialog = new Merchant();
        dialog.setId("1");
        dialog.setDescription("Dialog Telecom Compnay  PVT LTD");
        dialog.setName("Dialog Telecom");

        final  Merchant etisalat = new Merchant();
        etisalat.setId("2");
        etisalat.setDescription("Etisalt Telecom Compnay  PVT LTD");
        etisalat.setName("Etisalat Mobile");


        final Merchant ceb = new Merchant();
        ceb.setId("3");
        ceb.setDescription("Celyon Electricty Board");
        ceb.setName("Electricity Bill");

        return new ArrayList<Merchant>(){{add(dialog); add(etisalat); add(ceb);}};
    }

    @Override
    public PayBillResponse pay(PayBillRequest payBillRequest) {
        PayBillResponse payBillResponse = new PayBillResponse();
        if("1".equals(payBillRequest.getMerchantId())) {
            payBillResponse.setTransactionId("987654258");
            payBillResponse.setResultCode(PayBillResponseCode.SUCCESS_0000);
            payBillResponse.setDescription(PayBillResponseCode.SUCCESS_0000.getDescription());
        } else {
            payBillResponse.setTransactionId("987654258");
            payBillResponse.setResultCode(PayBillResponseCode.FAILED_0001);
            payBillResponse.setDescription(PayBillResponseCode.FAILED_0001.getDescription());
        }

        return payBillResponse;
    }
}
