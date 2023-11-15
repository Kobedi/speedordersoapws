package com.zadscience.springsoap;

import com.zadscience.springsoap.gen.ConfirmDeliveryRequest;
import com.zadscience.springsoap.gen.DeliveryConfirmation;
import com.zadscience.springsoap.gen.GetDeliveryResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@Endpoint
public class OrderfulfilmentEndpoint {

    private static final String NAMESPACE_URI = "http://www.zadscience.com/springsoap/gen";


    @Autowired
    private OrderfufilmentRepository orderfulfilmentRepository;

    @Autowired
    public OrderfulfilmentEndpoint(OrderfufilmentRepository orderfulfilmentRepository) {
        this.orderfulfilmentRepository = orderfulfilmentRepository;
    }


    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "confirmDeliveryRequest")
    @ResponsePayload
    public GetDeliveryResponse confirmDelivery(@RequestPayload ConfirmDeliveryRequest request) {
        DeliveryConfirmation deliveryConfirmation = null;
        GetDeliveryResponse response = new GetDeliveryResponse();
        deliveryConfirmation = orderfulfilmentRepository.findDeliveryConfirmation(request.getName());
        response.setDeliveryConfirmation(deliveryConfirmation);
        return response;
    }


}
