package edu.nju.RabbitMQInSpringBoot.controller;

import edu.nju.RabbitMQInSpringBoot.consumer.Consumer;
import edu.nju.RabbitMQInSpringBoot.producer.Producer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: Bright Chan
 * @date: 2020/7/29 10:58
 * @description: TODO
 */

@RestController
@RequestMapping("/rabbitmq")
public class TestController {

    @Autowired
    private Producer producer;

    @Autowired
    private Consumer consumer;

    @GetMapping("/test")
    public String test() {
        producer.send();
        return "success";
    }

    @GetMapping("/allMsg")
    public String getAllMsg() {
        return consumer.getAllMsg();
    }
}
