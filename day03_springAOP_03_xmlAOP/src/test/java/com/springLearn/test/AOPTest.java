package com.springLearn.test;

/**
 * Created by s on 2020/6/10 09:50.
 */

import com.springLearn.service.IAccountService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 账户的测试类
 * 该案例为基于xml的AOP配置，与动态代理类似，使用AOP来增强方法
 *
 * 1. 获取spring容器
 * 2. 获取account对象
 * 3. 执行方法
 */
public class AOPTest {
    public static void main(String[] args) {
        // 1. 获取spring的ioc容器
        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
        // 2. 获取对象
        IAccountService as = ac.getBean("accountService", IAccountService.class);

        // 3. 执行方法
        as.saveAccount();
//        as.updateAccount(1, 2);
//        as.deleteAccount();
    }
}
