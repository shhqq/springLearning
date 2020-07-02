package com.springboot.logTest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LogTestApplication {

    public static void main(String[] args) {
        Logger logger = LoggerFactory.getLogger(LogTestApplication.class);
//        logger.trace("this is a trace logger.");
//        logger.debug("this is a debug logger");
//
//        logger.info("this is an info logger");
//        logger.warn("this is a warn logger");
//        logger.error("this is an error logger");
        SpringApplication.run(LogTestApplication.class, args);
    }

}
