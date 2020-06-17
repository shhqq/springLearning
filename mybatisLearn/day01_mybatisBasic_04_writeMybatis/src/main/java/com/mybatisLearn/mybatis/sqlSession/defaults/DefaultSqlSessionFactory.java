package com.mybatisLearn.mybatis.sqlSession.defaults;

import com.mybatisLearn.mybatis.config.Configuration;
import com.mybatisLearn.mybatis.sqlSession.SqlSession;
import com.mybatisLearn.mybatis.sqlSession.SqlSessionFactory;

/**
 * Created by s on 2020/6/17 10:17.
 */

/**
 * SqlSession接口的实现类
 */
public class DefaultSqlSessionFactory implements SqlSessionFactory {

    private Configuration cfg;

    /**
     * 提供一个带参数的构造方法，强制创建对象时，传入一个Configuration对象
     * @param cfg Configuration
     */
    public DefaultSqlSessionFactory(Configuration cfg){
        this.cfg = cfg;
    }

    /**
     * 用于打开一个SqlSession对象
     *
     * @return
     */
    @Override
    public SqlSession openSession() {
        return new DefaultSqlSession(cfg);
    }
}
