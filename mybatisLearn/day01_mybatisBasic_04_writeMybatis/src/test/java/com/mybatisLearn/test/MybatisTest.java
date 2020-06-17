package com.mybatisLearn.test;

/**
 * Created by s on 2020/6/16 11:19.
 */

import com.mybatisLearn.dao.IUserDao;
import com.mybatisLearn.domain.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;
import java.util.List;

/**
 * 测试类
 */
public class MybatisTest {

    /**
     * 入门案例的测试
     * @param args
     */
    public static void main(String[] args) throws Exception {
        // 1. 读取配置文件
        InputStream in = Resources.getResourceAsStream("SqlMapConfig.xml");

        // 2. 创建sqlSessionFactory工厂
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        SqlSessionFactory factory = builder.build(in);

        // 3. 使用工厂生成SqlSession对象
        SqlSession session = factory.openSession();

        // 4. 使用SqlSession创建Dao接口的代理对象--相当于dao接口的实现
        IUserDao userDao = session.getMapper(IUserDao.class);

        // 5. 使用代理对象调用dao的方法
        List<User> users = userDao.findAll();
        for (User user: users){
            System.out.println(user);
        }

        // 6. 释放资源
        session.close();
        in.close();
    }
}
