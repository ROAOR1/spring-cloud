package com.example.hystrixclient8007.hystrixobservablecommanddemo;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.ObservableExecutionMode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import rx.Observable;

@Service
public class MyHystrixObservableService {

    @Autowired
    private RestTemplate restTemplate;

    /**
     * ObservableExecutionMode.EAGER 热执行（默认）
     * ObservableExecutionMode.LAZY 冷执行
     * @return
     */
    @HystrixCommand(fallbackMethod = "fallback", observableExecutionMode = ObservableExecutionMode.LAZY)
    public Observable<String> construct(){
        return Observable.create(subscriber ->{
            try {
                if (!subscriber.isUnsubscribed()){
                    //将结果收集起来
                    subscriber.onNext(restTemplate.getForEntity("http://eureka-client/sayHello/",String.class).getBody());
                    subscriber.onNext(restTemplate.getForEntity("http://eureka-client/sayHello/",String.class).getBody());
                    subscriber.onNext(restTemplate.getForEntity("http://eureka-client/sayHello/",String.class).getBody());
                    //通知执行完成
                    subscriber.onCompleted();
                }
            }catch (Exception e){
                subscriber.onError(e);
            }

        });
    }

    public Observable<String> fallback(){
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
