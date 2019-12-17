package com.example.feignclient8006.top.service;

import org.springframework.stereotype.Component;

@Component
public class FeignServiceImpl implements FeignService {
    @Override
    public String sayHello() {
        return "调用sayHello方法出错";
    }

    @Override
    public String sayName(String name) {
        return "调用sayName方法出错";
    }
}
