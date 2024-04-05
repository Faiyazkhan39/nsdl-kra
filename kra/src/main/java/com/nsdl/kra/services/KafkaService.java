package com.nsdl.kra.services;


import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaService {

    private KafkaTemplate<String,String> kafkaTemplate;

    public KafkaService(KafkaTemplate<String , String> kafkaTemplate){
        this.kafkaTemplate = kafkaTemplate; 
    }
    public void sendMsg(String msg){
        System.out.println(msg);
        kafkaTemplate.send("nsdlTest",msg);
    }

}
