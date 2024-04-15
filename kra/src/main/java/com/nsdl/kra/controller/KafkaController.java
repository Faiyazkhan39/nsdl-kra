package com.nsdl.kra.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.nsdl.kra.services.KafkaService;


@RestController
@RequestMapping("/kafka")
public class KafkaController {

    @Autowired
    private KafkaService kafkaService;

    @GetMapping("/save")
    public ResponseEntity<String> savemeg(@RequestParam("msg") String msg) {
        kafkaService.sendMsg(msg);
        return ResponseEntity.ok("message sent to Kafka");
    }
    
}
