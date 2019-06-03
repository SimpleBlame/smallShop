package com.blame.li.order.message;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * 接受mq消息
 * Create by li
 * 2019/5/26 15:22
 */
@Slf4j
@Component
public class MqReceiver {

    //@RabbitListener(queues = "myQueue")
    //自动创建队列@RabbitListener(queuesToDeclare = @Queue("myQueue"))
    @RabbitListener(bindings = @QueueBinding(
            value = @Queue("myQueue"),
            exchange = @Exchange("myExchange")
    ))
    public void process(String message){
        log.info("MyReceiver: {}",message);
    }

    /**
     * 数码服务接受mq消息
     * @param message
     */
    @RabbitListener(bindings = @QueueBinding(
            exchange = @Exchange("myOrder"),
            key = "computer",
            value = @Queue("computerOrder")

    ))
    public void processComputer(String message){
        log.info("computer MyReceiver: {}",message);
    }

    /**
     * 水果服务接受mq消息
     * @param message
     */
    @RabbitListener(bindings = @QueueBinding(
            exchange = @Exchange("myOrder"),
            key = "fruit",
            value = @Queue("FruitOrder")

    ))
    public void processFruit(String message){
        log.info("fruit MyReceiver: {}",message);
    }


}
