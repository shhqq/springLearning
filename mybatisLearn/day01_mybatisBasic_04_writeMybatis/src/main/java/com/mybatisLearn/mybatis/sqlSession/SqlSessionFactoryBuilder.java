package com.mybatisLearn.mybatis.sqlSession;

/**
 * Created by s on 2020/6/17 09:05.
 */

import com.mybatisLearn.mybatis.config.Configuration;
import com.mybatisLearn.mybatis.sqlSession.defaults.DefaultSqlSessionFactory;
import com.mybatisLearn.mybatis.utils.XMLConfigBuilder;

import java.io.InputStream;

/**
 * 用于创建SqlSessionFactory工厂的类
 */
public class SqlSessionFactoryBuilder {

    /**
     * 通过字节输入流，创建SqlSessionFactory工厂
     * @param config
     * @return
     */
    public SqlSessionFactory build(InputStream config){
        Configuration cfg = XMLConfigBuilder.loadConfiguration(config);
        return new DefaultSqlSessionFactory(cfg);
    }
}
