package com.springLearn.jdbcTemplate;

/**
 * Created by s on 2020/6/10 14:23.
 */

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

/**
 * jdbc Template的基本用法
 * 1. 首先导入依赖
 *      spring-context, spring-jdbc, spring-tx, mysql-connector-java
 */
public class JdbcTemplateDemo1 {
    public static void main(String[] args){
        // 1. 创建DataSource--使用spring的内置数据源
        DriverManagerDataSource ds = new DriverManagerDataSource();
        ds.setDriverClassName("com.mysql.cj.jdbc.Driver");
        ds.setUrl("jdbc:mysql://localhost:3306/mydbtest");
        ds.setUsername("root");
        ds.setPassword("123456");

        // 2. 创建jdbcTemplate对象
        JdbcTemplate jt = new JdbcTemplate();
        // 3. 设置datasource，也可以使用带ds的构造函数
        jt.setDataSource(ds);

        // 4. 执行操作
        // jt.execute("insert into account(name, money) values('ddd', 3000)");
        jt.update("insert into account(name, money) values('ddd', 3000)");
    }
}
