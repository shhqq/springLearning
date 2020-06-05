package com.springDemo.service.impl;

/**
 * Created by s on 2020/6/3 09:43.
 */

import com.springDemo.service.IAccountService;
import com.springDemo.dao.IAccountDao;
import com.springDemo.dao.impl.AccountDaoImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;

/**
 * 账户的业务层实现类
 *
 *    <bean id="accountService" class="com.spring.service.impl.AccountServiceImpl"
 *    scope="singleton" init-method="" destroy-method="">
 *       <property name="" value="" / ref=""></property>
 *
 * 1. 用于创建对象的注解
 *      与在xml文件中使用bean标签一致
 *      Component
 * 2. 用于注入数据的注解
 *      与xml文件中使用bean标签和property标签一致，即使用set方法一致
 *      Autowired：
 *          作用：自动**按照类型**注入，只要容器中有唯一的一个bean对象类型和要注入的类型匹配，就可以注入。
 *              没有任何bean类型与要注入的数据类型一致，则报错。
 *              如果容器中存在多个与要注入的变量类型一致的对象，则会按照名称查找，没有名称相同的，则报错。
 *              （这种是比较麻烦的，也不够灵活）
 *          出现位置：
 *              可以是变量上，也可以是*方法*上。
 *          细节：
 *              使用注解注入时，set方法就不是必须的了。
 *          弊端：
 *              Autowired是线程不安全的，Resource是线程安全的
 *      Qualifier
 *          作用：在按照类注入的基础上，再按照名称注入，它给类成员注入时，不能单独使用，但给方法参数注入时，可以。
 *          属性： value，用于指定注入bean的id。
 *      Resource
 *          作用：直接按照bean的id注入，可以单独使用。
 *          属性： name，用于指定注入bean的id。
 *      注意：以上三个注解只能注入其他bean类型的数据，不能注入基本数据类型和string类型。
 *           复合参数类型只能通过xml来配置。（TODO: 待验证）
 *      Value：
 *          作用：用于基本数据类型和string类型
 *          属性：value，用于指定数据的值，还可以使用spring中的spEL表达式。
 * 3. 用于改变作用范围的
 *      与xml文件中使用scope属性一致
 *      Scope：
 * 4. 与生命周期相关的
 *      与xml文件中使用init-method和destroy-method属性一致
 *      PostConstruct
 *      PreDestroy
 */

// @Component("accountService") // 有且只有一个属性，且为value时，value可以省略
@Service
public class AccountServiceImpl implements IAccountService {

    //这里并不new对象，如果不加注解，则会报NullPointerException
//    @Autowired          // 使用注解，自动注入对象，可以不用set方法，给成员赋值。
//    @Qualifier
    @Resource
    private IAccountDao accountDao;

    public AccountServiceImpl(){
        System.out.println("对象创建了");
    }

    /**
     * 生命周期控制--生成方法
     */
    @PostConstruct
    public void init(){
        System.out.println("post construct annotation");
    }

    /**
     * 生命周期控制--销毁方法
     */
    @PreDestroy
    public void destroy(){
        System.out.println("pre destroy annotation.");
    }

    @Override
    public void saveAccount() {
        accountDao.saveAccount();
    }
}
