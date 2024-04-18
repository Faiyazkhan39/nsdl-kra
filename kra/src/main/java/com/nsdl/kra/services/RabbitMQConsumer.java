package com.nsdl.kra.services;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class RabbitMQConsumer {

    @RabbitListener(queues = "nsdlQueue")
    public void consume(String msg) {
        System.out.println("Rabbit MQ msg : " + msg);
    }
}
