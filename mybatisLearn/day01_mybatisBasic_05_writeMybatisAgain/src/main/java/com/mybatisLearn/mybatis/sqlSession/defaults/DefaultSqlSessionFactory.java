package com.mybatisLearn.mybatis.sqlSession.defaults;

/**
 * Created by s on 2020/6/17 14:59.
 */

import com.mybatisLearn.mybatis.config.Configuration;
import com.mybatisLearn.mybatis.sqlSession.SqlSession;
import com.mybatisLearn.mybatis.sqlSession.SqlSessionFactory;

/**
 * SqlSessionFactory的实现类
 */
public class DefaultSqlSessionFactory implements SqlSessionFactory {

    private Configuration cfg;

    /**
     * 提供一个构造函数，包括一个参数，参数是包括配置
     * @param cfg Configuration配置对象
     */
    public DefaultSqlSessionFactory(Configuration cfg){
        this.cfg = cfg;
    }

    /**
     * 打开一个新的SqlSession对象
     *
     * @return
     */
    @Override
    public SqlSession openSession() {
        return new DefaultSqlSession(cfg);
    }
}
