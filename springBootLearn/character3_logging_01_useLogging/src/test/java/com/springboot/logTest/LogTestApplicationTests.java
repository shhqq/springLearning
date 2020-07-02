package com.springboot.logTest;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

//@RunWith(SpringRunner.class)

/**
 * springBoot的日志
 * 1. 使用slf4j的LoggerFactory创建一个记录器，
 * 2. 记录器的日志有5个级别，可以指定级别
 * 3. 日志输出格式
 * 4. 生成日志文件
 * 5. 创建日志配置文件logback-spring.xml
 * 6. 日志框架切换，一般用不到，了解原理就可以
 */
@SpringBootTest
class LogTestApplicationTests {

    org.slf4j.Logger logger = LoggerFactory.getLogger(getClass());

    @Test
    void contextLoads() {
        logger.info("============");
        logger.trace("this is a trace logger.");
        logger.debug("this is a debug logger");

        logger.info("this is an info logger");
        logger.warn("this is a warn logger");
        logger.error("this is an error logger");
    }

}
