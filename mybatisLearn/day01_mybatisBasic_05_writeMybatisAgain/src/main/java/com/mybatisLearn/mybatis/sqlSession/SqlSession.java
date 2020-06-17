package com.mybatisLearn.mybatis.sqlSession;

/**
 * Created by s on 2020/6/17 14:49.
 */

/**
 * SqlSession接口，它是与数据库交互的核心
 */
public interface SqlSession {

    /**
     * 动态代理，提供dao接口的代理对象
     * @param <T>   泛型，需要先声明，再使用
     * @return 代理对象
     */
    <T> T getMapper(Class<T> daoInterfaceClass);

    /**
     * 释放资源
     */
    void close();
}
