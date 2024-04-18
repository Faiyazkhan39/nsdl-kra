package com.nsdl.kra.services;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumer {

    @KafkaListener(topics = "nsdlTest", groupId = "nsdl")
    public void cunsume(String msg) {
        System.out.println(msg);
    }
}
