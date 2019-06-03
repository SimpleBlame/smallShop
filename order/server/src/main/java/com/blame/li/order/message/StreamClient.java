package com.blame.li.order.message;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.SubscribableChannel;

/**
 * Create by li
 * 2019/5/26 16:54
 */
public interface StreamClient {

    String INPUT = "input";
    String OUTPUT = "output";

    String INPUT2 = "input2";
    String OUTPUT2 = "output2";

    @Input(StreamClient.INPUT)
    SubscribableChannel input();

    @Output(StreamClient.OUTPUT)
    MessageChannel output();

    //@Input(StreamClient.INPUT2)
    //SubscribableChannel input2();

    //@Output(StreamClient.OUTPUT2)
    //MessageChannel output2();


}
