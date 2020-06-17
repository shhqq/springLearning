package com.mybatisLearn.mybatis.sqlSession.proxy;

import com.mybatisLearn.mybatis.config.Mapper;
import com.mybatisLearn.mybatis.utils.Executor;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.sql.Connection;
import java.util.Map;

/**
 * Created by s on 2020/6/17 10:36.
 */

/**
 * 编写一个InvocationHandler接口的实现类，用于在动态代理中使用
 */
public class MapperProxy implements InvocationHandler {

    private Map<String, Mapper> mappers;
    private Connection conn;

    /**
     * 提供一个构造方法， 添加两个参数，创建该对象时，必须传入两个参数
     * @param mappers Map of Mapper
     * @param conn java.sql.Connection
     */
    public MapperProxy(Map<String, Mapper> mappers, Connection conn){
        this.mappers = mappers;
        this.conn = conn;
    }

    /**
     * 基于接口的动态代理中的方法调用
     * @param proxy 要代理的对象
     * @param method 要增强的方法
     * @param args 要增强的方法的参数
     * @return 与要增强的方法的返回值相同
     * @throws Throwable
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        // 1. 获取方法名称，也就是映射配置中的id
        String methodName = method.getName();
        // 2. 获取类的全限定类名，也就是映射配置中的namespace
        String className = method.getDeclaringClass().getName();
        // 3. 组合起来构成key，用于在Mappers获取Mapper对象，
        String key = className + "." + methodName;
        // 4. 获取Mapper
        Mapper mapper = mappers.get(key);
        // 5. 判断是否存在
        if(mapper == null){
            throw new IllegalArgumentException("传入的参数有误");
        }
        // 6. 如果存在，则调用工具类进行查询
        return new Executor().selectList(mapper, conn);
    }
}
