package com.blame.li.order.controller;

import com.blame.li.order.dto.OrderDTO;
import com.blame.li.order.message.StreamClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * Create by li
 * 2019/6/2 17:15
 */
@RestController
public class SendMessageController {

    @Autowired
    private StreamClient streamClient;

    /*@GetMapping("/sendMessage")
    public void process(){
        String message = "now " + new Date();
        streamClient.output().send(MessageBuilder.withPayload(message).build());
    }*/


    @GetMapping("/sendMessage")
    public void process(){
        OrderDTO orderDTO = new OrderDTO();
        orderDTO.setOrderId("123456");
        streamClient.output().send(MessageBuilder.withPayload(orderDTO).build());
    }

}
