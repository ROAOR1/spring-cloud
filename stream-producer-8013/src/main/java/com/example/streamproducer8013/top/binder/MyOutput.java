package com.example.streamproducer8013.top.binder;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

public interface MyOutput {
    String MYOUTPUT = "myOutput";

    //方法名是什么无所谓
    @Output("myOutput")
    MessageChannel output();
}
