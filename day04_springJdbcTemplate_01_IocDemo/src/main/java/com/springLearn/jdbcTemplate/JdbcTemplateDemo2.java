package com.springLearn.jdbcTemplate;

/**
 * Created by s on 2020/6/10 14:23.
 */

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

/**
 * jdbc Template的基于注解的ioc
 *
 */
public class JdbcTemplateDemo2 {
    public static void main(String[] args){
        // 1. 构建spring容器
        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");

        // 2. 创建jdbcTemplate对象
        JdbcTemplate jt = ac.getBean("jdbcTemplate", JdbcTemplate.class);

        // 4. 执行操作
        // jt.execute("insert into account(name, money) values('ddd', 3000)");
        jt.update("insert into account(name, money) values('eee', 5000)");
    }
}
