package com.ssm.test;

/**
 * Created by s on 2020/6/29 18:34.
 */

import com.ssm.service.IAccountService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 测试类
 */
public class AccountTest {

    /**
     * 测试spring框架
     */
    @Test
    public void testRun1(){
        ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
        IAccountService accountService = (IAccountService) ac.getBean("accountService");
        accountService.findAll();
    }
}
