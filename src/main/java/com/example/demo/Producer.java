package com.example.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

@Component
public class Producer {
    Logger log = LoggerFactory.getLogger(Producer.class);
    private static final String DEFAULT_EXCHANGE = "";
    private final RabbitTemplate rabbitTemplate;

    public Producer(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
        this.rabbitTemplate.setExchange(DEFAULT_EXCHANGE);
    }

    public void sendMessage(String queueOrRoutingKey, String message) {
        log.debug("Sending message: {}", message);
        rabbitTemplate.convertAndSend(queueOrRoutingKey, message);
    }

    public void sendRequest(String queueOrRoutingKey, MyRequest myRequest) {
        log.debug("Sending a Request: {}", myRequest);
        rabbitTemplate.convertAndSend(DEFAULT_EXCHANGE, queueOrRoutingKey, myRequest);
    }
}
