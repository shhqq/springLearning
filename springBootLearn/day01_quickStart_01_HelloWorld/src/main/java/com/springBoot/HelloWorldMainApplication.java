package com.springBoot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Created by s on 2020/6/30 09:58.
 */
@SpringBootApplication  // 表明这是一个springboot应用类，为主程序类
public class HelloWorldMainApplication {

    public static void main(String[] args){
        // 启动springboot的应用
        SpringApplication.run(HelloWorldMainApplication.class, args);
    }
}
