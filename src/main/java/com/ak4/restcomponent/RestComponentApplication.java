package com.ak4.restcomponent;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan(basePackages = {
        "com.ak4.config",
        "com.ak4.rest",
        "com.ak4.mapper",
        "com.ak4.service",
        "com.ak4.facade",
        "com.ak4.exception"
})
@EnableJpaRepositories(basePackages = "com.ak4.repository")
public class RestComponentApplication {

    public static void main(String[] args) {
        SpringApplication.run(RestComponentApplication.class, args);
    }

}

