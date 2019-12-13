package com.example.feignclient8006.top.controller;

import com.example.feignclient8006.top.service.FeignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/feign")
public class FeignController {

    @Autowired
    private FeignService feignService;

    @RequestMapping("/sayHello")
    public void sayHello(){
        System.out.println(feignService.sayHello());
    }

    @RequestMapping("/sayName")
    public void sayName(String name){
        System.out.println(feignService.sayName(name));
    }
}
