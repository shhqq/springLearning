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
        // 延迟加载中，如果不访问关联数据，则不会查询
//        users.forEach(System.out::println);
    }

    /**
     * 测试保存用户方法
     */
    @Test
    public void testSave(){
        User user = new User();
        user.setUsername("insert item");
        user.setSex("男");

        userDao.saveUser(user);
        System.out.println(user);
    }

    /**
     * 测试更新用户
     */
    @Test
    public void testUpdate(){
        User user = new User();
        user.setId(49);
        user.setUsername("update item");
        user.setAddress("nan j");

        userDao.updateUser(user);
    }

    /**
     * 测试删除用户
     */
    @Test
    public void testDelete(){
        userDao.deleteUser(49);
    }

    /**
     * 测试查询一个
     */
    @Test
    public void testFindById(){
        User user = userDao.findById(48);
        System.out.println(user);
    }

    /**
     * 测试模糊查询
     */
    @Test
    public void testFindUsersFuzzy(){
        List<User> users = userDao.findUsersFuzzy("%王%");
        users.forEach(System.out::println);
    }

    /**
     * 测试查询总数
     */
    @Test
    public void testFindTotal(){
        int total = userDao.findTotal();
        System.out.println(total);
    }
}
