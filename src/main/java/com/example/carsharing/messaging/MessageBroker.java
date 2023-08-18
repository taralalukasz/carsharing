package com.example.carsharing.messaging;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class MessageBroker {

    private AmqpTemplate template;


    @Autowired
    public MessageBroker(AmqpTemplate template) {
        this.template = template;
    }

    public void sendMessage(String queue, String message) {
        template.convertAndSend(queue, message);
    }
}
