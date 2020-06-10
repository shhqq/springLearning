package com.springLearn.dao.impl;

import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

/**
 * Created by s on 2020/6/10 16:56.
 */

/**
 * 自己编写JdbcDaoSupport
 * 抽取Dao中的实现类中的jdbcTemplate，
 */
public class JdbcDaoSupport {
    /**
     * 创建jdbcTemplate对象，并生成set方法，由spring的ioc注入
     */
    private JdbcTemplate jdbcTemplate;
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }

    /**
     * 提供get方法供子类使用
     * @return
     */
    public JdbcTemplate getJdbcTemplate(){
        return jdbcTemplate;
    }

    // dataSource 其实并不需要
//    private DataSource dataSource;

    /**
     * 也可以使用setDataSource，间接创建一个jdbcTemplate对象.
     * 这时候在bean.xml的配置AccountDao中，可以使用DataSource，间接创建jdbcTemplate对象
     * @param dataSource
     */
    public void setDataSource(DataSource dataSource){
//        this.dataSource = dataSource;
        if(jdbcTemplate == null){
            jdbcTemplate = createJdbcTemplate(dataSource);
        }
    }

    /**
     * 生成一个JdbcTemplate
     * @param dataSource    dataSource
     * @return              new JdbcTemplate
     */
    private JdbcTemplate createJdbcTemplate(DataSource dataSource){
        return new JdbcTemplate(dataSource);
    }
}
