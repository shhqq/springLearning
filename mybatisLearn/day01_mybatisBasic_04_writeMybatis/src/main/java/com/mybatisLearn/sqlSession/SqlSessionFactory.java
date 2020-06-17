package com.mybatisLearn.sqlSession;

/**
 * Created by s on 2020/6/17 09:06.
 */

/**
 * SqlSessionFactory是一个接口，用于创建一个SqlSession对象
 */
public interface SqlSessionFactory {

    /**
     * 用于打开一个SqlSession对象
     * @return
     */
    SqlSession openSession();
}
