package com.mybatisLearn.mybatis.sqlSession.defaults;

/**
 * Created by s on 2020/6/17 15:03.
 */

import com.mybatisLearn.mybatis.config.Configuration;
import com.mybatisLearn.mybatis.proxy.MapperProxy;
import com.mybatisLearn.mybatis.sqlSession.SqlSession;
import com.mybatisLearn.mybatis.utils.DataSourceUtil;

import java.lang.reflect.Proxy;
import java.sql.Connection;

/**
 * SqlSession实现类
 */
public class DefaultSqlSession implements SqlSession {

    private Configuration cfg;
    private Connection conn;

    /**
     * 提供一个构造函数，用于传入Configuration对象，
     * 同时在构造函数中，调用DataSourceUtil的getConnection方法，获取一个连接
     * @param cfg
     */
    public DefaultSqlSession(Configuration cfg){
        this.cfg = cfg;
        conn = new DataSourceUtil().getConnection(cfg);
    }

    /**
     * 动态代理，提供dao接口的代理对象
     *
     * @param daoInterfaceClass@return 代理对象
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
            } catch(Exception e){
                e.printStackTrace();    // 这里就没必要用RuntimeException
            }
        }
    }
}
