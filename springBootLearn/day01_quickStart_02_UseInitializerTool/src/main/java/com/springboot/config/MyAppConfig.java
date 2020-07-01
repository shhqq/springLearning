package com.springboot.config;

/**
 * Created by s on 2020/7/1 10:44.
 */

import com.springboot.domain.Dog;
import com.springboot.domain.Person;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * springBoot 推荐使用注解的方法将对象添加到容器
 * 编写一个配置类，用于注入数据
 * @Configuration: 表明当前类是一个配置类，用来代替Spring的配置文件bean.xml
 *
 * 有一个问题，这里Person对象如何赋值？使用set方法不好吧
 */
@Configuration  // 表示这是一个spring配置类
@PropertySource(value = "classpath:person.properties")  // 数据配置
public class MyAppConfig {

    @Bean   // 将方法的返回值加入ioc容器中，默认id就是方法名。
    public Person person(){
        System.out.println("在配置类中，使用@Bean注解为ioc容器添加组件。。");
        return new Person();
    }
}
