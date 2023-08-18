package com.example.carsharing.configuration;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JmsConfig {

    @Value("${spring.rabbitmq.username}")
    private String username;
    @Value("${spring.rabbitmq.password}")
    private String password;
    @Value("${spring.rabbitmq.host}")
    private String queueHost;
    @Value("${spring.rabbitmq.queue}")
    private String queue;

    @Value("${spring.rabbitmq.port}")
    private int port;

    @Bean
    public CachingConnectionFactory connectionFactory() {
        CachingConnectionFactory connectionFactory =
                new CachingConnectionFactory(queueHost);
        connectionFactory.setUsername(username);
        connectionFactory.setPassword(password);
        connectionFactory.setPort(port);
        return connectionFactory;
    }

    @Bean
    public Queue myQueue() {
        return new Queue(queue);
    }

    @RabbitListener(queues = "myqueue")
    public void listen(String in) {
        System.out.println("listener triggered");
        System.out.println(in);
    }
}
