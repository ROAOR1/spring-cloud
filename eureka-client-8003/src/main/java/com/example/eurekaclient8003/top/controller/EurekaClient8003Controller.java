package com.example.eurekaclient8003.top.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EurekaClient8003Controller {
    @RequestMapping("/sayHello")
    public String sayHello(){
        return "Hello，这里是EurekaClient8003客户端";
    }

    @RequestMapping("/sayName")
    public String sayName(String name){
        return "EurekaClient8003客户端："+name;
    }
}
