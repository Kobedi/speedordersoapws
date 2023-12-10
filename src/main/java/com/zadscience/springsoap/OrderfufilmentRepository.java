package com.zadscience.springsoap;

//import com.baeldung.springsoap.gen.*;
import com.zadscience.springsoap.gen.*;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import javax.annotation.PostConstruct;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Map;

@Component
public class OrderfufilmentRepository {


    private static final Map<String, DeliveryConfirmation> confirmations = new HashMap<>();


    @PostConstruct
    public void initData() throws DatatypeConfigurationException {
        DeliveryConfirmation deliveryOne = new DeliveryConfirmation();
        deliveryOne.setTrackingNumber("123456");
        Order order = new Order();
        order.setOrderNumber("2468");
        Calendar c = GregorianCalendar.getInstance();
        c.add(Calendar.DATE, 7);//Add an extra 7 days
        c.get(Calendar.YEAR);
        //int year, int month, int dayOfMonth, int hourOfDay,
        //                             int minute
        final GregorianCalendar now = new GregorianCalendar(
                c.get(Calendar.YEAR),
        c.get(Calendar.MONTH),c.get(Calendar.DAY_OF_MONTH),
                c.get(Calendar.HOUR),c.get(Calendar.MINUTE));
        order.setOrderDate(DatatypeFactory.newInstance().
                newXMLGregorianCalendar(now));
        deliveryOne.setEstimatedDeliveryDate(DatatypeFactory.newInstance().
                newXMLGregorianCalendar(now));
        Product product = new Product();
        product.setName("My Product");
        product.setDescription("Mad at me");
        product.setType("Fragile");

        deliveryOne.setOrder(order);
        order.setProduct(product);

        Shipper shipper = new Shipper();
        final GregorianCalendar tnow = new GregorianCalendar();
        shipper.setTrackingNumber(deliveryOne.getTrackingNumber());
        shipper.setShippingDate(DatatypeFactory.newInstance().
                newXMLGregorianCalendar(tnow));
        deliveryOne.setShipper(shipper);
        confirmations.put(deliveryOne.getTrackingNumber(), deliveryOne);


    }

    public DeliveryConfirmation findDeliveryConfirmation(String trackNumber) {
        Assert.notNull(trackNumber, "The delivery track number must not be null");
        return confirmations.get(trackNumber);
    }

}
