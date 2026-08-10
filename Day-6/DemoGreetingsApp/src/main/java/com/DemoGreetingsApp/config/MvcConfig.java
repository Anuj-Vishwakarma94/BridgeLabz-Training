package com.DemoGreetingsApp.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
public class MvcConfig {

    @Bean
    public InternalResourceViewResolver jspViewResolver() {

        InternalResourceViewResolver resolver = new InternalResourceViewResolver();

        resolver.setPrefix("/WEB-INF/views/");
        resolver.setSuffix(".jsp");

        resolver.setViewNames("login", "register", "update-password");

        resolver.setOrder(1);

        return resolver;
    }

}