package com.ssm.test;

/**
 * Created by s on 2020/6/29 09:38.
 */

import com.ssm.service.IAccountService;
import com.ssm.service.impl.AccountServiceImpl;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 测试类
 * 这里将测试类写在了main.java中，是为了加入git
 * 要在main.java中使用单元测试，需要将junit坐标的scope改为compile
 */
public class AccountTest {

    @Test
    public void testRun1(){
        // 1. 读取配置文件
        ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
        // 2. 获取ioc容器中的对象
        IAccountService as = (AccountServiceImpl) ac.getBean("accountService");
        // 3. 执行对应的方法
        as.findAll();


    }
}
