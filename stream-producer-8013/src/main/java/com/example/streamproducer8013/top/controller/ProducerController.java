package com.example.streamproducer8013.top.controller;

import com.example.streamproducer8013.top.binder.Producer;
import com.example.streamproducer8013.top.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProducerController {
    @Autowired
    private Producer producer;

    @RequestMapping("/sendMsg")
    public void sendMsg(){
        User user = new User(1,"小王");
        producer.sendMsg(user);
    }
}
