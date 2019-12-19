package com.example.hystrixclient8007.merge;

import com.netflix.hystrix.strategy.concurrency.HystrixRequestContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

@RestController
public class MyHystrixMergeController {
    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping("/merge")
    public void merge() throws ExecutionException, InterruptedException {
        //进行初始化操作，不加这个会报错
        HystrixRequestContext context = HystrixRequestContext.initializeContext();
        MyHystrixCollapser mergeCollapser1 = new MyHystrixCollapser(1,restTemplate);
        MyHystrixCollapser mergeCollapser2 = new MyHystrixCollapser(2,restTemplate);
        MyHystrixCollapser mergeCollapser3 = new MyHystrixCollapser(3,restTemplate);

        //这里必须使用异步请求，否则不会合并
        Future<String> future1 = mergeCollapser1.queue();
        Future<String> future2 = mergeCollapser2.queue();
        Future<String> future3 = mergeCollapser3.queue();

        System.out.println(future1.get());
        System.out.println(future2.get());
        System.out.println(future3.get());
    }

    @Autowired
    private MyHystrixMergeService myHystrixMergeService;

    @RequestMapping("/merge2")
    public void merge3() throws ExecutionException, InterruptedException {
        HystrixRequestContext context = HystrixRequestContext.initializeContext();

        Future<String> future1 = myHystrixMergeService.merge(1);
        Future<String> future2 = myHystrixMergeService.merge(2);
        Future<String> future3 = myHystrixMergeService.merge(3);

        System.out.println(future1.get());
        System.out.println(future2.get());
        System.out.println(future3.get());
    }
}
