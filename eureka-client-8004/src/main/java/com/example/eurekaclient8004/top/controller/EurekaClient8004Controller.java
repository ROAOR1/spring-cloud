package com.example.eurekaclient8004.top.controller;

import com.example.eurekaclient8004.top.service.MyHystrixService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class EurekaClient8004Controller {
    @RequestMapping("/sayHello")
    public String sayHello(){
        return "Hello，这里是EurekaClient8004客户端";
    }

    @RequestMapping("/sayName")
    public String sayName(String name){
        return "EurekaClient8004客户端："+name;
    }

    /**
     * Hystrix请求合并调用该方法
     * @param id
     * @return
     */
    @RequestMapping("/merge")
    public List<String> demo(String id){
        System.out.println("合并之后的请求参数："+id);
        System.out.println("这里应该拿到单个的请求参数，分别去数据库中查询，为了方便我就用集合模拟了请求结果");
        List<String> list = new ArrayList<>();
        list.add("模拟请求结果：result1");
        list.add("模拟请求结果：result2");
        list.add("模拟请求结果：result3");
        return list;
    }

    @Autowired
    private MyHystrixService myHystrixService;

    /**
     * 测试时Hystrix仪表盘调用此方法
     */
    @RequestMapping("/hystrixTest")
    public void hystrixTest(){
        myHystrixService.execute();
    }
}
