package com.springboot.webtest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.ViewResolver;

import java.util.Locale;

@SpringBootApplication
public class WebtestApplication {

    public static void main(String[] args) {
        SpringApplication.run(WebtestApplication.class, args);
    }

    /**
     * 编写一个ViewResolver实现类，提供一个方法，将对象加入容器
     * 在DispatcherServlet.java中的doDispatch()方法加一个断点，debug下就可以看到自定义的ViewResolver对象
     * @return
     */
    @Bean
    public ViewResolver myViewResolver(){
        return new myViewResolver();
    }

    public static class myViewResolver implements ViewResolver{

        @Override
        public View resolveViewName(String s, Locale locale) throws Exception {
            return null;
        }
    }
}
