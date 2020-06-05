package com.springDemo.ui;

/**
 * Created by s on 2020/6/3 09:54.
 * 将基于xml的spring工程改为使用注解的方式
 * 1. 在xml中配置注解
 * 2. 在xml中配置扫描注解路径
 * 3. 添加注解
 */

import com.springDemo.dao.IAccountDao;
import com.springDemo.service.IAccountService;
import com.springDemo.service.impl.AccountServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 表现层
 * 模拟表现层，用于调用业务层，在实际中，应该是一个servlet。
 */
public class Client {

    /**
     * @param args
     */
    public static void main(String[] args) {

//        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
        // 改为实现类，因为ApplicationContext没有close方法。
        ClassPathXmlApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");

        // 使用spring注解的方式，spring容器中生成了对象
        IAccountService as = (AccountServiceImpl) ac.getBean("accountServiceImpl");
        System.out.println(as);

//        IAccountDao aDao = ac.getBean("accountDao", IAccountDao.class);
//        System.out.println(aDao);

        as.saveAccount();

        // 关闭容器，演示as对象的销毁方法
        ac.close();
    }
}
