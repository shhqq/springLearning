package config;

/**
 * Created by s on 2020/6/5 14:38.
 */

import com.mchange.v2.c3p0.ComboPooledDataSource;
import com.mchange.v2.c3p0.DataSources;
import org.apache.commons.dbutils.QueryRunner;
import org.springframework.context.annotation.*;

import javax.sql.DataSource;
import java.beans.PropertyVetoException;


/**
 * 这是一个配置类
 * day02_springAnnotation_04_AllAnno需要将bean.xml文件去掉，全部使用注解
 *       需要解决两个问题：
 *           1. QueryRunner的DataSource配置
 *           2. context:component-scan需要删除
 * 新的注解：
 *      Configuration
 *          作用：声明此类为一个配置类
 *          细节：当配置类作为AnnotationConfigApplicationContext的参数是，该注解可以省略。
 *      ComponentScan
 *          作用：指定spring容器构建时需要扫描的路径。相当于配置了<context:component-scan base-package=""/>
 *          属性：value（与basePackages相同），指定扫描路径
 *      Bean
 *          作用：用于将方法的返回值加入到spring的ioc容器中
 *          属性：name指定ioc容器中对象的key。当不指定时，默认为方法名。
 *          细节：当用注解配置方法时，如果方法有参数，spring框架会去容器中查找是否有可用bean对象，查找方式与Autowired相同。
 *      Import
 *          作用：用于导入其他配置类
 *          属性：value，数组，用于指定其他配置类的字节码，
 *              当使用Import注解时，包含Import的配置类为父配置类，导入的都是子配置类。
 *              当使用Import注解时，子配置类不需要Configuration注解，也不需要加入ComponentScan参数中，也不需要加入
 *                  AnnotationConfigApplicationContext参数中。
 *      将jdbcConfig.java中的数据库连接信息改写为配置文件
 *          使用新的注解
 *              PropertySource
 *                  作用：用于指定properties文件的位置
 *                  属性：
 *                      value: 指定文件的名称和路径
 *                          使用classpath关键字表示类路径下。
 */
//@Configuration
@ComponentScan({"com.springLearn"})    // value是一个string数组，当只有一个值时，{}可以省略，只有value时，value可以省略
@Import(JdbcConfig.class)
@PropertySource("classpath:jdbcConfig.properties")  // classpath关键字表示是类路径。
public class SpringConfiguration {

}
