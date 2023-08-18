package com.example.carsharing.api;

import com.example.carsharing.messaging.MessageBroker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    private MessageBroker messageBroker;

    private String queue;

    @Autowired
    public TestController(MessageBroker messageBroker, @Value("${spring.rabbitmq.queue}") String queue) {
        this.messageBroker = messageBroker;
        this.queue = queue;
    }

    @GetMapping(value = "/welcome")
    public void welcome() {
        System.out.println("queue " + queue );
        messageBroker.sendMessage(queue,"welcome to the app");
    }
}
