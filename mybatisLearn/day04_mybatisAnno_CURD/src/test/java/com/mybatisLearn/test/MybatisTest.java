package com.mybatisLearn.test;

/**
 * Created by s on 2020/6/22 16:51.
 */

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
 * 测试类
 */
public class MybatisTest {

    private InputStream in;
    private SqlSession session;
    private IUserDao userDao;

    @Before // 测试方法执行前执行
    public void init() throws Exception{
        in = Resources.getResourceAsStream("XmlMapConfig.xml");
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        SqlSessionFactory factory = builder.build(in);
        session = factory.openSession();
        userDao = session.getMapper(IUserDao.class);
    }

    @After // 测试方法执行后释放资源
    public void destroy() throws Exception{
        session.commit();
        session.close();
        in.close();
    }

    /**
     * 测试查询所有用户方法
     */
    @Test
    public void testListAllUsers(){
        List<User> users = userDao.listAllUsers();
        users.forEach(System.out::println);
    }
}
