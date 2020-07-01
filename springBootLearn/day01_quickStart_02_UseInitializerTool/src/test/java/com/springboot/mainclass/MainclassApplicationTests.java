package com.springboot.mainclass;

import com.springboot.domain.Person;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)    // 自动生成的项目需要添加，并添加junit依赖坐标
@SpringBootTest
class MainclassApplicationTests {
    @Autowired
    Person person;

    @Autowired
    ApplicationContext ac;
//    ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");

    @Test
    void contextLoads() {
        System.out.println("测试ConfigurationProperties");
        System.out.println(person);
    }

    /**
     * 测试配置spring的配置文件bean.xml
     */
    @Test
    void testBeanXml(){
        boolean b = ac.containsBean("BeanPerson");
        System.out.println(b);
    }
}
