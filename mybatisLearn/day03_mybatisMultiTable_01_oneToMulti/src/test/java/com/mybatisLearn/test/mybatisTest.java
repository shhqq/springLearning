package com.mybatisLearn.test;

import com.mybatisLearn.dao.IUserDao;
import com.mybatisLearn.domain.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;
import java.util.List;

/**
 * Created by s on 2020/6/19 17:50.
 */

/**
 * 本项目是从来测试mybatis的多表操作
 * 
 */

public class mybatisTest {

    private InputStream in;
    private SqlSession session;
    private IUserDao userDao;

    @Before // 测试方法执行前
    public void init() throws Exception{
        in = Resources.getResourceAsStream("XmlMapConfig.xml");
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        SqlSessionFactory factory = builder.build(in);
        session = factory.openSession();
        userDao = session.getMapper(IUserDao.class);
    }

    @After // 测试方法执行后
    public void destroy() throws Exception{
        session.commit();
        in.close();
        session.close();
    }

    /**
     * 测试查询所有方法
     */
    @Test
    public void testFindAll(){
        List<User> users = userDao.findAll();
        for(User user : users){
            System.out.println(user);
        }
    }
}
