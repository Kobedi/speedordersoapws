package com.zadscience.springsoap.client;

import com.zadscience.springsoap.gen.ConfirmDeliveryRequest;
import com.zadscience.springsoap.gen.GetDeliveryResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;

public class OrderfulFilmentClient extends WebServiceGatewaySupport {

    private static final Logger logger = LoggerFactory.getLogger(OrderfulFilmentClient.class);

    public GetDeliveryResponse confirmDelivery(String orderNumber) {

        ConfirmDeliveryRequest request = new ConfirmDeliveryRequest();
        request.setName(orderNumber);
        logger.info("Requesting order information for " + orderNumber);
        GetDeliveryResponse response1 = (GetDeliveryResponse) getWebServiceTemplate().marshalSendAndReceive(request);
        return response1;
    }

}