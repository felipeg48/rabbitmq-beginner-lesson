package com.example.demo;

import org.springframework.amqp.core.Queue;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.EventListener;

@Configuration
public class DemoApplicationConfig {

    private final Producer producer;

    public DemoApplicationConfig(Producer producer) {
        this.producer = producer;
    }

    @Bean
    public Queue createMyQueue() {
        return new Queue("myQueue");// This method is empty, but the @Queue annotation will create a queue named "myQueue"
    }

    @EventListener(ApplicationReadyEvent.class)
    public void doSomethingAfterStartup() {
        producer.sendMessage("myQueue", "Hello, world!");
        producer.sendRequest("myRequest", new MyRequest("Hello, world!", 42, true));
    }

}
