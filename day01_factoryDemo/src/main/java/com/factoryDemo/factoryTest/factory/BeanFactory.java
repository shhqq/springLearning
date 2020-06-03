package com.factoryDemo.factoryTest.factory;

/**
 * Created by s on 2020/6/3 09:57.
 */

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 * 工厂模式
 * 一个创建Bean对象的工厂，使用工厂模式解耦合
 ** 什么是Bean：在计算机英语中，有可重用组件的含义。
 *  * 例如：service可以被很多servlet使用，dao可以被很多service使用
 *  *
 *  * JavaBean：
 *  *      使用java语言编写的可重用组件。
 *  *      javaBean 范围远大于 实体类。实体类仅是可重用组件的一部分。
 *  *
 *  * 该类是创建service和dao对象的，即工厂模式的一般形式：
 *  *      1. 需要一个配置文件来配置service和dao
 *  *      2. 通过读取配置文件中的配置的内容，反射来创建对象。
 *  *
 *  * 配置文件可以是xml，也可以是properties。
 */
public class BeanFactory {
    // 定义一个Properties对象，保存配置
    private static Properties props;

    // 定义一个容器，用于存放要创建的对象
    private static Map<String, Object> beanMap;

    // 使用静态代码块为Properties对象赋值
    static {
        try{
            // 实例化对象
            props = new Properties();

            // 获取Properties文件的流对象
            // 不可以使用FileInputStream，尤其是web项目，因为这种需要指明路径，
//            InputStream in = new FileInputStream("...");

            InputStream in = BeanFactory.class.getClassLoader().getResourceAsStream("bean.properties");
            props.load(in);

            // 将配置保存到beanMap中
            // 1. 实例化HashMap对象
            beanMap = new HashMap<>();
            // 2. 获取所有配置
            Enumeration<Object> keys = props.keys();
            // 3. 遍历配置，存储对象
            while(keys.hasMoreElements()){
                String beanName = keys.nextElement().toString();
                // 4. 获取一个对象
                Object o = Class.forName(props.getProperty(beanName)).getConstructor().newInstance();
                // 5. 存储对象
                beanMap.put(beanName, o);
            }
        } catch (Exception e){
            e.printStackTrace();
            // 抛一个错误，该错误会直接退出程序，因为配置失败后，后续都无法执行。
            throw new ExceptionInInitializerError("初始化Properties失败");
        }
    }

    /**
     * 改写getBean方法，直接返回beanMap中的元素
     * @param beanName  类名
     * @return  类的对象
     */
    public static Object getBean(String beanName){
        return beanMap.get(beanName);
    }

    /**
     * 根据类名获取对象
     * 由于在该方法中使用newInstance()获取对象，因此每调用该方法，就会产生一个对对象。
     * 造成资源浪费。
     * @param beanName 类名
     * @return  类的对象
     */
    /*
    public static Object getBean(String beanName){
        Object bean = null;
        try {
            // 获取配置
            String beanPath = props.getProperty(beanName);
            // 通过反射获取类名，之后新建一个对象。
            bean = Class.forName(beanPath).getConstructor().newInstance();
        } catch (Exception e){
            e.printStackTrace();
        }
        return bean;
    }

     */
}
