package com.springLearn.test;

/**
 * Created by s on 2020/6/5 12:19.
 */

import com.springLearn.domain.Account;
import com.springLearn.service.IAccountService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * 使用junit单元测试，测试我们的配置
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:bean.xml")
public class AccountServiceTest {

    /**
     * bean.xml中配置了两个AccountService，所以需要使用Qualifier指定名称
     */
    @Autowired
    private IAccountService as;

    /**
     * 右键自动生成testMethod
     */
    @Test
    public void testFindAll() {
//        // 1. 获取spring容器
//        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
//        // 2. 得到业务层对象
//        IAccountService as = (IAccountService) ac.getBean("accountService");
        // 3. 执行方法，sql
        List<Account> accounts = as.findAllAccount();
        // 4. 遍历结果
        for(Account acc : accounts){
            System.out.println(acc);
        }
    }

    @Test
    public void testTransfer(){
        as.transfer("aaa", "bbb", 200F);
    }
}
