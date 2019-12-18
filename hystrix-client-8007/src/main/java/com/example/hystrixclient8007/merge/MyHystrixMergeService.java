package com.example.hystrixclient8007.merge;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCollapser;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.concurrent.Future;

@Service
public class MyHystrixMergeService {
    @Autowired
    private RestTemplate restTemplate;


    @HystrixCollapser(batchMethod = "getMerge", collapserProperties = {@HystrixProperty(name = "timerDelayInMilliseconds", value = "200")})
    public Future<Integer> merge(Integer id){
        return null;
    }


    @HystrixCommand
    public String getMerge(List<Integer> ids){
        System.out.println("合并的请求："+ids.toString());
        String result = restTemplate.getForEntity("http://eureka-client/merge?ids={1}",String.class,ids).getBody();
        System.out.println("合并后的结果"+result);
        return result;
    }
}
