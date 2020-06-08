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
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * 使用junit单元测试，测试我们的配置
 *
 * 改写测试类
 *  1. 应用程序的入口是main方法
 *  2. junit单元测试中，
 *      junit集成了一个main方法
 *      该方法就会判断当前测试类中哪些有@Test注解
 *      junit会让有@Test注解的方法执行。
 *  3. junit不管是否采用spring框架
 *      在执行方法时，junit不知道是否使用了spring
 *      所以，也不会读取配置文件或配置类创建spring核心容器
 *  4. 由以上3点可知
 *      当测试方法执行时， 没有Ioc容器，就算写了@Overwired注解，也无法实现注入数据。
 *
 *  使用Spring整合junit的配置
 *      1. 导入spring整合junit的jar（坐标）
 *      2. 使用junit提供的一个注解，把原有的main方法替换为spring提供的；
 *          作用：用来创建spring容器
 *      3. 告知spring运行器，spring的ioc创建时基于xml的还是注解的，并且说明位置。
 *          @ContextConfiguration
 *              Locations: 指定xml文件的位置，加上classpath关键字，表示类路径
 *              classes: 指定注解类所在的位置
 *   Notice: 当使用spring版本为5.x以上时，要求junit的jar包版本高于4.12
 *
 *   不应该有ApplicationContext对象，因为测试者不应该涉及spring的配置，
 *   而是直接注入IAccountService对象。
 */
@ContextConfiguration(classes = SpringConfiguration.class)  // 本例使用注解，所以用classes，表示注解类的字节码文件对象
@RunWith(SpringJUnit4ClassRunner.class)
public class AccountServiceTest {

    @Autowired
    private IAccountService as;
    /**
     * 右键自动生成testMethod
     */
    @Test
    public void testFindAll() {
        // 1. 获取spring容器
////        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
//        ApplicationContext ac = new AnnotationConfigApplicationContext(SpringConfiguration.class);

        // 2. 得到业务层对象
//        as = (IAccountService) ac.getBean("accountService");

        // 3. 执行方法，sql
        List<Account> accounts = as.findAllAccount();

        // 4. 遍历结果
        for(Account acc : accounts){
            System.out.println(acc);
        }

    }

    @Test
    public void testFindOne() {
        Account account = as.findAccountById(1);
        System.out.println(account);
    }

    @Test
    public void testSave() {
        // 新建Account对象
        Account account = new Account();
        account.setName("ddd");
        account.setMoney(1800F);

        // 保存数据
        as.saveAccount(account);
    }

    @Test
    public void testUpdate() {
        Account account = as.findAccountById(1);
        account.setMoney(3000F);

        as.updateAccount(account);
    }

    @Test
    public void testDelete() {
        as.deleteAccount(4);
    }

    /**
     * 测试spring容器中的QueryRunner对象是否为多例
     */
//    @Test
//    public void testQueryRunner(){
////        ApplicationContext ac = new AnnotationConfigApplicationContext(SpringConfiguration.class);
//        QueryRunner runner1 = ac.getBean("runner", QueryRunner.class);
//        QueryRunner runner2 = ac.getBean("runner", QueryRunner.class);
//        System.out.println(runner1 == runner2);
//    }

}
