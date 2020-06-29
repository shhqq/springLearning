package com.ssm.test;

/**
 * Created by s on 2020/6/29 09:38.
 */

import com.ssm.dao.IAccountDao;
import com.ssm.domain.Account;
import com.ssm.service.IAccountService;
import com.ssm.service.impl.AccountServiceImpl;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.InputStream;
import java.util.List;

/**
 * 测试类
 * 这里将测试类写在了main.java中，是为了加入git
 * 要在main.java中使用单元测试，需要将junit坐标的scope改为compile
 */
public class AccountTest {

    /**
     * 单独测试Spring框架
     */
    @Test
    public void testRun1(){
        // 1. 读取配置文件
        ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
        // 2. 获取ioc容器中的对象
        IAccountService as = (AccountServiceImpl) ac.getBean("accountService");
        // 3. 执行对应的方法
        as.findAll();
    }

    /**
     * 测试dao中的Mybatis框架
     */
    @Test
    public void testRun2() throws Exception{
        // 1. 加载配置文件
        InputStream in = Resources.getResourceAsStream("XmlMapConfig.xml");
        // 2. 创建builder
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        // 3. 创建工厂
        SqlSessionFactory factory = builder.build(in);
        // 4. 打开一个session
        SqlSession session = factory.openSession();
        // 5. 获取dao的代理对象
        IAccountDao accountDao = session.getMapper(IAccountDao.class);

        // 6. 遍历结果
        List<Account> accounts = accountDao.findAll();
        accounts.forEach(System.out::println);

        // 7. 关闭资源
        session.close();
        in.close();
    }
}
