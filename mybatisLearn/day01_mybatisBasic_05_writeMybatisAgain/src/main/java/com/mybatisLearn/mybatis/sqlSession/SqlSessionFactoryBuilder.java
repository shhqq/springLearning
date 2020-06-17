package com.mybatisLearn.mybatis.sqlSession;

/**
 * Created by s on 2020/6/17 14:46.
 */

import com.mybatisLearn.mybatis.config.Configuration;
import com.mybatisLearn.mybatis.sqlSession.defaults.DefaultSqlSessionFactory;
import com.mybatisLearn.mybatis.utils.XMLConfigBuilder;

import java.io.InputStream;

/**
 * SqlSessionFactory工厂的构建者类
 */
public class SqlSessionFactoryBuilder {

    public SqlSessionFactory build(InputStream in){
        // 此处解析配置文件，保存到Configuration对象中，并创建SqlSessionFactory实现类对象
        Configuration cfg = XMLConfigBuilder.loadConfiguration(in);
        return new DefaultSqlSessionFactory(cfg);
    }
}
