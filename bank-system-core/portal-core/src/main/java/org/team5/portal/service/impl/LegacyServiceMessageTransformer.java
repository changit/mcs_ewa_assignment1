package org.team5.portal.service.impl;

import org.iso8583.payload.FundTransfer;
import org.team5.portal.data.FundTransferRequest;

/**
 * Created with IntelliJ IDEA.
 * User: chan
 * Date: 12/29/12
 * Time: 9:37 PM
 * To change this template use File | Settings | File Templates.
 */
public class LegacyServiceMessageTransformer {
    
    FundTransfer toFundTransfer(FundTransferRequest fundTransferRequest){
        FundTransfer fundTransfer = new FundTransfer();
        //TODO do transformation here
        return fundTransfer;
    }

    //TODO add rest of transformation
            
}
