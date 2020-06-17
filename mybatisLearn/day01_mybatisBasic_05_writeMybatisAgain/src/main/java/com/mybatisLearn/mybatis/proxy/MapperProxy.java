package com.mybatisLearn.mybatis.proxy;

/**
 * Created by s on 2020/6/17 15:09.
 */

import com.mybatisLearn.mybatis.config.Mapper;
import com.mybatisLearn.mybatis.utils.Executor;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.sql.Connection;
import java.util.Map;

/**
 * InvocationHandler接口的实现类
 */
public class MapperProxy implements InvocationHandler {

    private Map<String, Mapper> mappers;
    private Connection conn;

    /**
     * 提供一个构造函数，用户传入Mapper和Connection
     * @param mappers
     * @param conn
     */
    public MapperProxy(Map<String, Mapper> mappers, Connection conn){
        this.mappers = mappers;
        this.conn = conn;
    }
    /**
     * 实现invoke方法，获取mapper中的Mapper对象，调用工具类，工具类中有selectList方法
     * @param proxy 被代理对象
     * @param method 调用的方法
     * @param args 调用的方法的参数
     * @return 调用的方法的返回值
     * @throws Throwable
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        // 1. 首先获取方法名，即id
        String methodName = method.getName();
        // 2. 获取全限定类名，即namespace
        String className = method.getDeclaringClass().getName();
        // 3. 组合为key
        String key = className + "." + methodName;
        // 4. 获取mappers中的对象
        Mapper mapper = mappers.get(key);
        // 5. 判断是否存在
        if(mapper == null){
            throw new IllegalArgumentException("参数有误");
        }
        // 6. 如果存在，调用工具类方法，返回list
        return new Executor().selectList(mapper, conn);
    }
}
