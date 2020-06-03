package com.factoryDemo.factoryTest.ui;

/**
 * Created by s on 2020/6/3 09:54.
 */

import com.factoryDemo.factoryTest.dao.IAccountDao;
import com.factoryDemo.factoryTest.service.IAccountService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 表现层
 * 模拟表现层，用于调用业务层，在实际中，应该是一个servlet。
 */
public class Client {

    /**
     * 获取spring的Ioc核心容器，并根据id获取对象
     * @param args
     */
    public static void main(String[] args) {
        // 表现层调用业务层，使用new创建对象，这里是一个耦合
//        IAccountService as = new AccountServiceImpl();

        // 1. 获取核心容器对象
        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
        // 2. 根据id获取Bean对象
        IAccountService as = (IAccountService) ac.getBean("accountService");
        // 使用带两个参数的getBean方法会返回指定的类对象。
        IAccountDao aDao = ac.getBean("accountDao", IAccountDao.class);

        // 3. 调用业务层对象的方法
        as.saveAccount();
    }
}
