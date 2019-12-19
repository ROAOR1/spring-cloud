package com.example.streamtransfer8014.top.transfer;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

public interface MyTransfer {
    String MYOUTPUT = "myOutput";
    String MYINPUT = "myInput";

    @Output("myOutput")
    MessageChannel output();

    @Input("myInput")
    MessageChannel input();
}
