package com.blame.li.order.message;

import com.blame.li.order.dto.OrderDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Component;

/**
 * Create by li
 * 2019/6/2 17:11
 */
@Component
@EnableBinding(StreamClient.class)
@Slf4j
public class StreamReceiver {


    /*@StreamListener(StreamClient.INPUT)
    public void process(Object message){
        log.info("StreamReceiver: {}" + message);
    }*/


    /**
     * 接收orderDTO 消息
     * @param message
     */
    @StreamListener(StreamClient.INPUT)
    //@SendTo(StreamClient.INPUT2)
    public void process(OrderDTO message){
        log.info("StreamReceiver: {}" + message);
        // 发送mq消息
        //return "input2";
    }

    /*@StreamListener(StreamClient.INPUT2)
    public void process(String message){
        log.info("StreamReceiver2: {}" + message);
    }*/


}
