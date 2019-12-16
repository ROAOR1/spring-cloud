package com.example.hystrixclient8007.hystrixcommanddemo;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.command.AsyncResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.concurrent.Future;

@Service
public class MyHystrixService {

    @Autowired
    private RestTemplate restTemplate;

    //同步请求
    @HystrixCommand(fallbackMethod = "getFallBack")
    public String execute(){
        return restTemplate.getForEntity("http://eureka-client/sayHello/",String.class).getBody();
    }

    //异步请求
    @HystrixCommand(fallbackMethod = "getFallBack")
    public Future<String> queue(){
        return new AsyncResult<String>() {
            @Override
            public String invoke() {
                return restTemplate.getForEntity("http://eureka-client/sayHello/",String.class).getBody();
            }

            @Override
            public String get() throws UnsupportedOperationException {
                return invoke();
            }
        };
    }

    public String getFallBack(){
        return "调用eureka-client服务失败";
    }
}
