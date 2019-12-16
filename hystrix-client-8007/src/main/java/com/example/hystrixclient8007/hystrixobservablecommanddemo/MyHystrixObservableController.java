package com.example.hystrixclient8007.hystrixobservablecommanddemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import rx.Observable;
import rx.Subscriber;

import java.util.ArrayList;
import java.util.List;

@RestController
public class MyHystrixObservableController {

    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping("/observe")
    public void observe(){
        List<String> list = new ArrayList<>();

        MyHystrixObservableCommand myHystrixObservableCommand = new MyHystrixObservableCommand(restTemplate);
        //热执行
        Observable<String> observe = myHystrixObservableCommand.observe();

        //冷执行
        //Observable<String> observe = myHystrixObservableCommand.toObservable();
        observe.subscribe(new Subscriber<String>() {
            @Override
            public void onCompleted() {
                System.out.println("执行完成");
            }

            @Override
            public void onError(Throwable throwable) {
                throwable.printStackTrace();
            }

            @Override
            public void onNext(String result) {
                System.out.println("收集结果");
                list.add(result);
            }
        });

        System.out.println(list);
    }

    @Autowired
    private MyHystrixObservableService myHystrixObservableService;

    @RequestMapping("/observe2")
    public void observe2(){
        List<String> list = new ArrayList<>();

        Observable<String> observe = myHystrixObservableService.construct();
        observe.subscribe(new Subscriber<String>() {
            @Override
            public void onCompleted() {
                System.out.println("执行完成");
            }

            @Override
            public void onError(Throwable throwable) {
                throwable.printStackTrace();
            }

            @Override
            public void onNext(String result) {
                System.out.println("收集结果");
                list.add(result);
            }
        });

        System.out.println(list);
    }
}
