package com.mybatisLearn.mybatis.sqlSession;

/**
 * Created by s on 2020/6/17 14:47.
 */

/**
 * SqlSessionFactory工厂
 */
public interface SqlSessionFactory {

    /**
     * 打开一个新的SqlSession对象
     * @return
     */
    SqlSession openSession();
}
