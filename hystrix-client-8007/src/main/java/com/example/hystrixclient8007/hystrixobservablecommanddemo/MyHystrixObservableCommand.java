package com.example.hystrixclient8007.hystrixobservablecommanddemo;

import com.netflix.hystrix.HystrixCommandGroupKey;
import com.netflix.hystrix.HystrixObservableCommand;
import org.springframework.web.client.RestTemplate;
import rx.Observable;

public class MyHystrixObservableCommand extends HystrixObservableCommand<String> {

    private RestTemplate restTemplate;

    public MyHystrixObservableCommand(RestTemplate restTemplate){
        super(HystrixCommandGroupKey.Factory.asKey("MyHystrixObservableCommand"));
        this.restTemplate = restTemplate;
    }

    //执行逻辑
    @Override
    protected Observable<String> construct() {
        return Observable.create(subscriber -> {
            try {
                if (!subscriber.isUnsubscribed()){
                    //将结果收集起来
                    subscriber.onNext(restTemplate.getForEntity("http://eureka-client/sayHello/",String.class).getBody());
                    subscriber.onNext(restTemplate.getForEntity("http://eureka-client/sayHello/",String.class).getBody());
                    subscriber.onNext(restTemplate.getForEntity("http://eureka-client/sayHello/",String.class).getBody());
                    //通知执行完成
                    subscriber.onCompleted();
                }
            } catch (Exception e) {
                subscriber.onError(e);
            }
        });
    }

    //服务降级
    @Override
    public Observable<String> resumeWithFallback(){
        return Observable.create(subscriber -> {
            try {
                if (!subscriber.isUnsubscribed()){
                    subscriber.onNext("调用eureka-client服务失败");
                    subscriber.onCompleted();
                }
            } catch (Exception e) {
                subscriber.onError(e);
            }
        });
    }
}
