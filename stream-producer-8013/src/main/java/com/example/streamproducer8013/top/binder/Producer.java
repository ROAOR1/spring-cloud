package com.example.streamproducer8013.top.binder;

import com.example.streamproducer8013.top.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.support.MessageBuilder;

//绑定输出通道
@EnableBinding(MyOutput.class)
public class Producer {
    @Autowired
    private MyOutput myOutput;

    public void sendMsg(User user){
        myOutput.output().send(MessageBuilder.withPayload(user).build());
    }
}
