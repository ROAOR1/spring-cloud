package com.example.hystrixclient8007.hystrixcommanddemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.concurrent.ExecutionException;


@RestController
public class MyHystrixController {
    @Autowired
    private RestTemplate restTemplate;

    //同步执行
    @RequestMapping("/execute")
    public void execute(){
        MyHystrixCommand myHystrixCommand = new MyHystrixCommand(restTemplate);
        System.out.println(myHystrixCommand.execute());
    }

    //异步执行
    @RequestMapping("/queue")
    public void queue() throws ExecutionException, InterruptedException {
        MyHystrixCommand myHystrixCommand = new MyHystrixCommand(restTemplate);
        System.out.println(myHystrixCommand.queue().get());
    }

    @Autowired
    private MyHystrixService myHystrixService;

    //同步执行
    @RequestMapping("/execute2")
    public void execute2(){
        System.out.println(myHystrixService.execute());
    }

    //异步执行
    @RequestMapping("/queue2")
    public void queue2() throws ExecutionException, InterruptedException {
        System.out.println(myHystrixService.queue().get());
    }
}
