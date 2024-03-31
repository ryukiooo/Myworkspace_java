package com.easypan.entity.config;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component("appConfig")
public class AppConfig {

    @Value("${spring.mail.username}")
    private String sendUsername;

    public String getSendUsername() {
        return sendUsername;
    }
}
