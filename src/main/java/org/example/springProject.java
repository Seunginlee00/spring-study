package org.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableAutoConfiguration
public class springProject {
    public static void main(String[] args) {
        SpringApplication.run(springProject.class, args);
    }
}
