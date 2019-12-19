package com.example.streamconsumer8015.top.consumer;

import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;

//绑定我们自定义的输入通道
@EnableBinding(MyInput.class)
public class Consumer {
    /**
     * 监控myInput通道，接收到的消息就是obj
     * @param obj 接收到的消息
     */
    @StreamListener(MyInput.MYINPUT)
    public void getMsg(Object obj){
        System.out.println(obj);
    }
}
