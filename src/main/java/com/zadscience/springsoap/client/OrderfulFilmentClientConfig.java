package com.zadscience.springsoap.client;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;

@Configuration
public class OrderfulFilmentClientConfig {

    @Bean
    public Jaxb2Marshaller marshaller() {
            Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
            marshaller.setContextPath("com.zadscience.springsoap.gen");
            return marshaller;
    }

    @Bean
    public OrderfulFilmentClient deliveryClient(Jaxb2Marshaller marshaller) {
        OrderfulFilmentClient client = new OrderfulFilmentClient();
            client.setDefaultUri("http://localhost:8080/ws");
            client.setMarshaller(marshaller);
            client.setUnmarshaller(marshaller);
            return client;
    }
}