package edu.nju.RabbitMQInSpringBoot.config;

import org.springframework.amqp.core.Queue;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * @author: Bright Chan
 * @date: 2020/7/29 10:55
 * @description: TODO
 */

@Configuration
@PropertySource("classpath:rabbitmq.properties")
public class RabbitMQConfig {

    @Value("${queue_name}")
    private String queueName;

    @Bean
    public Queue queue() {
        return new Queue(queueName);
    }
}
