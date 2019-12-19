package com.example.streamtransfer8014.top.transfer;

import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Processor;
import org.springframework.integration.annotation.ServiceActivator;

//绑定我们自定义的中转通道
@EnableBinding(MyTransfer.class)
public class Transfer {
    /**
     * 监控myInput通道，接收到的消息就是obj，最后发送加工过的消息到myOutput通道
     * @param obj 接收到的消息
     * @return 加工后的消息
     */
    @ServiceActivator(inputChannel = MyTransfer.MYINPUT, outputChannel = MyTransfer.MYOUTPUT)
    public Object getMsg(Object obj){
        //这里先将消息输出，再返回加工后的消息
        System.out.println(obj);
        return "经过中转者加工过的消息:"+obj;
    }
}
