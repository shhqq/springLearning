package com.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication
@ImportResource(value = "classpath:bean.xml")
public class MainclassApplication {

    public static void main(String[] args) {
        SpringApplication.run(MainclassApplication.class, args);
    }

}
