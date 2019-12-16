package com.example.hystrixclient8007.hystrixcommanddemo;

import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;
import org.springframework.web.client.RestTemplate;

public class MyHystrixCommand extends HystrixCommand<String> {

    private RestTemplate restTemplate;

    public MyHystrixCommand(RestTemplate restTemplate){
        super(HystrixCommandGroupKey.Factory.asKey("MyHystrixCommand"));
        this.restTemplate = restTemplate;
    }

    //HystrixCommand会执行这个方法发送请求
    @Override
    protected String run() throws Exception {
        return restTemplate.getForEntity("http://eureka-client/sayHello/",String.class).getBody();
    }

    //HystrixCommand会在熔断器开路、线程池拒绝、run方法执行过程中出现错误、超时等情况时执行该降级方法
    @Override
    protected String getFallback() {
        return "调用eureka-client服务失败";
    }
}
