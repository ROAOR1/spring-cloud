package com.example.eurekaclient8004.top.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.stereotype.Service;

@Service
public class MyHystrixService {
    //同步请求
    @HystrixCommand(fallbackMethod = "getFallBack")
    public void execute(){
        System.out.println("调用成功");
    }


    public void getFallBack(){
        System.out.println("调用失败");
    }
}
