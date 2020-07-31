package edu.nju.RabbitMQInSpringBoot.consumer;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @author: Bright Chan
 * @date: 2020/7/29 10:48
 * @description: TODO
 */

@Component
@RabbitListener(queues = "test-queue")
public class Consumer {

    private String store;

    @RabbitHandler
    public void process(String hello){
        store = hello;
        System.out.println("receive: " + hello);
    }

    public String getAllMsg() {
        return store;
    }
}
