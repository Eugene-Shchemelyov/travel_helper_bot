package com.gmail.eugene.travelbot.web.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.telegram.telegrambots.ApiContextInitializer;

@SpringBootApplication(
        scanBasePackages = "com.gmail.eugene.travelbot"
)
@EntityScan(basePackages = "com.gmail.eugene.travelbot.repository.model")
public class App {
    public static void main(String[] args) {
        ApiContextInitializer.init();
        SpringApplication.run(App.class, args);
    }
}
