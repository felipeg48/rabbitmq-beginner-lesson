package com.example.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Component
public class Consumer {
    Logger log = LoggerFactory.getLogger(Consumer.class);

    @RabbitListener(queues = "myQueue")
    public void receiveMessage(String message) {
        log.info("Received message: {}", message);
    }

    @RabbitListener(queuesToDeclare = @Queue("myRequest"))
    public void receiveRequestMessage(MyRequest myRequest) {
        log.info("Received request: {}", myRequest);
    }

    @Configuration
    static class ConsumerConfig {

        @Bean
        public MessageConverter messageConverter() {
            return new Jackson2JsonMessageConverter();
        }
    }

}
