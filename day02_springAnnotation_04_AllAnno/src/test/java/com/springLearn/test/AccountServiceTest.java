package com.springLearn.test;

/**
 * Created by s on 2020/6/5 12:19.
 */

import com.springLearn.domain.Account;
import com.springLearn.service.IAccountService;
import config.JdbcConfig;
import config.SpringConfiguration;
import org.apache.commons.dbutils.QueryRunner;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/**
 * 使用junit单元测试，测试我们的配置
 *
 */
public class AccountServiceTest {
    /**
     * 右键自动生成testMethod
     */
    @Test
    public void testFindAll() {
        // 1. 获取spring容器
//        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
        ApplicationContext ac = new AnnotationConfigApplicationContext(SpringConfiguration.class);

        // 2. 得到业务层对象
        IAccountService as = (IAccountService) ac.getBean("accountService");

        // 3. 执行方法，sql
        List<Account> accounts = as.findAllAccount();

        // 4. 遍历结果
        for(Account acc : accounts){
            System.out.println(acc);
        }

    }

    @Test
    public void testFindOne() {
        ApplicationContext ac = new AnnotationConfigApplicationContext(SpringConfiguration.class);
        IAccountService as = (IAccountService) ac.getBean("accountService");
        Account account = as.findAccountById(1);
        System.out.println(account);
    }

    @Test
    public void testSave() {

        ApplicationContext ac = new AnnotationConfigApplicationContext(SpringConfiguration.class);
        IAccountService as = (IAccountService) ac.getBean("accountService");
        // 新建Account对象
        Account account = new Account();
        account.setName("ddd");
        account.setMoney(1800F);

        // 保存数据
        as.saveAccount(account);
    }

    @Test
    public void testUpdate() {
        ApplicationContext ac = new AnnotationConfigApplicationContext(SpringConfiguration.class);
        IAccountService as = (IAccountService) ac.getBean("accountService");

        Account account = as.findAccountById(1);
        account.setMoney(3000F);

        as.updateAccount(account);
    }

    @Test
    public void testDelete() {
        ApplicationContext ac = new AnnotationConfigApplicationContext(SpringConfiguration.class);
        IAccountService as = (IAccountService) ac.getBean("accountService");
        as.deleteAccount(4);
    }

    /**
     * 测试spring容器中的QueryRunner对象是否为多例
     */
    @Test
    public void testQueryRunner(){
        ApplicationContext ac = new AnnotationConfigApplicationContext(SpringConfiguration.class);
        QueryRunner runner1 = ac.getBean("runner", QueryRunner.class);
        QueryRunner runner2 = ac.getBean("runner", QueryRunner.class);
        System.out.println(runner1 == runner2);
    }

}
