package com.example.feignclient8006.top.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "eureka-client", fallback = FeignServiceImpl.class)
public interface FeignService {

    //映射到sayHello方法
    @RequestMapping("/sayHello")
    String sayHello();

    @RequestMapping("/sayName")
    //使用注解@RequestParam映射（不加这个是映射不到的）
    String sayName(@RequestParam("name") String name);
}
