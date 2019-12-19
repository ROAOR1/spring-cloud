package com.example.streamconsumer8015.top.consumer;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.MessageChannel;

public interface MyInput {
    String MYINPUT = "myInput";

    @Input("myInput")
    MessageChannel input();
}
