package com.mybatisLearn.mybatis.sqlSession;

/**
 * Created by s on 2020/6/17 09:48.
 */

/**
 * SqlSession接口
 * 它是mybatis中和数据库交互的核心，可以创建dao接口的代理实现对象
 */
public interface SqlSession {

    /**
     * 用于创建一个dao接口的代理对象
     * @param daoInterfaceClass dao接口的字节码对象
     * @param <T> 泛型，需要先声明，后使用
     * @return 返回接口的代理实现对象
     */
    <T> T getMapper(Class<T> daoInterfaceClass);

    /**
     * 释放资源
     */
    void close();
}
