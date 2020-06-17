package com.mybatisLearn.mybatis.sqlSession.defaults;

/**
 * Created by s on 2020/6/17 10:21.
 */

import com.mybatisLearn.mybatis.config.Configuration;
import com.mybatisLearn.mybatis.sqlSession.SqlSession;
import com.mybatisLearn.mybatis.sqlSession.proxy.MapperProxy;
import com.mybatisLearn.mybatis.utils.DataSourceUtil;

import java.lang.reflect.Proxy;
import java.sql.Connection;

/**
 * SqlSession接口的实现类
 */
public class DefaultSqlSession implements SqlSession {

    Configuration cfg;
    Connection conn;

    /**
     * 提供一个带参数的构造方法，强制创建对象时，传入一个Configuration对象
     * @param cfg Configuration
     */
    public DefaultSqlSession(Configuration cfg){
        this.cfg = cfg;
        conn = DataSourceUtil.getConnection(cfg);
    }

    /**
     * 用于创建一个dao接口的代理对象
     *
     * @param daoInterfaceClass dao接口的字节码对象
     * @return 返回接口的代理实现对象
     */
    @Override
    public <T> T getMapper(Class<T> daoInterfaceClass) {
        return (T) Proxy.newProxyInstance(daoInterfaceClass.getClassLoader(),
                new Class[]{daoInterfaceClass}, new MapperProxy(cfg.getMappers(), conn));
    }

    /**
     * 释放资源
     */
    @Override
    public void close() {
        if(conn != null){
            try{
                conn.close();
            } catch (Exception e){
                e.printStackTrace();    // 这里的异常就没必要结束程序
            }
        }
    }
}
