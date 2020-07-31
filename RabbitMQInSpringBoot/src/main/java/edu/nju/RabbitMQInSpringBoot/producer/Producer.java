package edu.nju.RabbitMQInSpringBoot.producer;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * @author: Bright Chan
 * @date: 2020/7/29 10:52
 * @description: TODO
 */

@Component
@PropertySource("classpath:rabbitmq.properties")
public class Producer {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Value("${queue_name}")
    private String queueName;

    public void send() {
        for (int i = 0; i < 10; i++) {
            String msg = "hello: " + i;
            System.out.println("producer: " + msg);

            rabbitTemplate.convertAndSend(queueName, msg);
        }
    }
}
