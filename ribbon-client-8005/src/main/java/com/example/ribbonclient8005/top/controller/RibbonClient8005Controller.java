package com.example.ribbonclient8005.top.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class RibbonClient8005Controller {

    //用于发起请求
    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping("/getString")
    public void getString(){
        //通过服务名去调用
        System.out.println(restTemplate.getForEntity("http://eureka-client/sayHello/", String.class).getBody());
    }
}