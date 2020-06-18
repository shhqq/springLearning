package com.mybatisLearn.test;

import com.mybatisLearn.dao.IUserDao;
import com.mybatisLearn.dao.impl.UserDaoImpl;
import com.mybatisLearn.domain.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * Created by s on 2020/6/18 09:01.
 */
public class MybatisTest {

    private InputStream in;
    private SqlSession sqlSession;
    private IUserDao userDao;

    /**
     * 执行前的操作，创建对象
     * @throws Exception
     */
    @Before
    public void init() throws Exception{
        // 1. 读取配置文件到inputStream
        in = Resources.getResourceAsStream("XmlMapConfig.xml");
        // 2. 创建构建者，然后创建工厂
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        SqlSessionFactory sqlSessionFactory= builder.build(in);
        // 3. 创建SqlSession
//        sqlSession = sqlSessionFactory.openSession();
        // 4. 获取dao的代理对象    --改为使用实现类
//        userDao = sqlSession.getMapper(IUserDao.class);
        userDao = new UserDaoImpl(sqlSessionFactory);
    }

    /**
     * 执行完之后的操作，关闭资源
     */
    @After
    public void destroy() throws Exception{
//        // 这里需要调用提交，才能提交成功。
//        sqlSession.commit();
//        sqlSession.close();
        in.close();
    }

    /**
     * 测试查询所有
     */
    @Test
    public void testFindAll(){

        // 5. 调用方法
        List<User> users = userDao.findAll();
        for(User user : users){
            System.out.println(user);
        }
    }

    /**
     * 测试保存
     */
    @Test
    public void testSaveUser(){
        User user = new User();
        user.setUsername("insert impl item");
        user.setSex("男");
        user.setBirthday(new Date());
        user.setAddress("Nanjing");
        System.out.println(user);
        userDao.saveUser(user);
        // 使用selectKey获取数据库的主键值，将返回并赋值给user的id
        System.out.println(user);
    }

    /**
     * 测试更新用户
     */
    @Test
    public void testUpdateUser(){
        User user = new User();
        user.setId(50);
        user.setUsername("update impl");
        user.setSex("男");
        user.setAddress("Xi'an");
        user.setBirthday(new Date(2020-1900, Calendar.FEBRUARY, 23, 23,23,12));
        userDao.updateUser(user);
    }

    /**
     * 测试删除用户
     */
    @Test
    public void testDeleteUser(){
        userDao.deleteUser(53);
    }


    /**
     * 测试根据名称查询
     */
    @Test
    public void testFindUserByName(){
        String name = "update impl";
        User user = userDao.findUserByName(name);
        System.out.println(user);
    }
}
