package com.nsdl.kra.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.nsdl.kra.services.RabbitMQService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;


@RestController
@RequestMapping("/rabbit")
public class RabbitController {

    @Autowired
    RabbitMQService rabbitMQService;

    @PostMapping()
    public ResponseEntity<String> postRabbitMsg(@RequestParam("msg") String msg) {
        rabbitMQService.sendMsg(msg);

        return ResponseEntity.ok("msg save to RabbitMq");
    }

}
