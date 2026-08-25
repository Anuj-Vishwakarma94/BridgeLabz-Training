package com.FundooNotesApp.config;

import org.springframework.amqp.core.*;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {

    public static final String EXCHANGE = "auth.exchange";

    public static final String REGISTER_QUEUE = "auth.register.queue";
    public static final String LOGIN_QUEUE = "auth.login.queue";
    public static final String FORGOT_PASSWORD_QUEUE = "auth.forgot-password.queue";

    public static final String REGISTER_ROUTING_KEY = "auth.register";
    public static final String LOGIN_ROUTING_KEY = "auth.login";
    public static final String FORGOT_PASSWORD_ROUTING_KEY = "auth.forgot-password";

    @Bean
    public TopicExchange authExchange() {
        return new TopicExchange(EXCHANGE);
    }

    @Bean
    public Queue registerQueue() {
        return new Queue(REGISTER_QUEUE, true);
    }

    @Bean
    public Queue loginQueue() {
        return new Queue(LOGIN_QUEUE, true);
    }

    @Bean
    public Queue forgotPasswordQueue() {
        return new Queue(FORGOT_PASSWORD_QUEUE, true);
    }

    @Bean
    public Binding registerBinding(Queue registerQueue, TopicExchange authExchange) {
        return BindingBuilder.bind(registerQueue).to(authExchange).with(REGISTER_ROUTING_KEY);
    }

    @Bean
    public Binding loginBinding(Queue loginQueue, TopicExchange authExchange) {
        return BindingBuilder.bind(loginQueue).to(authExchange).with(LOGIN_ROUTING_KEY);
    }

    @Bean
    public Binding forgotPasswordBinding(Queue forgotPasswordQueue, TopicExchange authExchange) {
        return BindingBuilder.bind(forgotPasswordQueue).to(authExchange).with(FORGOT_PASSWORD_ROUTING_KEY);
    }

    @Bean
    public MessageConverter jsonMessageConverter() {
        return new Jackson2JsonMessageConverter();
    }
}
