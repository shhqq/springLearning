package com.jdbcDemo2;

import com.domain.Student;
import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;
import java.util.List;

/**
 * Created by s on 2020/6/17 17:11.
 */

/**
 * java使用数据库的第二种方式：使用JdbcTemplate
 * 需要继承JdbcDaoSupport类
 * 一般不直接用，用在spring的三层结构中
 */
public class UseJdbcTemplate extends JdbcDaoSupport{
    public static void main(String[] args) {
//        jdbcTemplateTest1();
//        jdbcTemplateTest2();
        jdbcTemplateTest3();
    }

    /**
     * 使用JdbcTemplate可以调用query等方法
     * 这个是使用了另一个类Helper，这个类继承JdbcDaoSupport类，
     */
    public static void jdbcTemplateTest1(){
        Helper help = new Helper();
        List<Student> students = help.jdbcTemplate.query("select * from student",
                new BeanPropertyRowMapper<>(Student.class));
        for(Student s: students){
            System.out.println(s);
        }
    }

    /**
     * 不使用Helper类，直接定义一个JdbcTemplate，还需要一个DataSource
     */
    public static void jdbcTemplateTest2(){
        System.out.println("JdbcTemplate使用DriverManagerDataSource作为数据源");

        JdbcTemplate jdbcTemplate = new JdbcTemplate();
        // 需要使用set设置四个要素，不能使用DataSource的多态，因为DataSource没有set方法
        DriverManagerDataSource ds = new DriverManagerDataSource();
        ds.setUrl("jdbc:mysql://localhost:3306/mydbtest");
        ds.setUsername("root");
        ds.setPassword("123456");
        jdbcTemplate.setDataSource(ds);

        // 第二个参数，需要传入Student类的字节码对象作为参数，也就是查询结果的封装类
        List<Student> students = jdbcTemplate.query("select * from student",
                new BeanPropertyRowMapper<>(Student.class));
        for(Student s: students){
            System.out.println(s);
        }
    }

    /**
     *
     */
    public static void jdbcTemplateTest3(){
        System.out.println("JdbcTemplate使用ComboPooledDataSource作为数据源");

        JdbcTemplate jdbcTemplate = new JdbcTemplate();
        // 需要使用set设置四个要素，不能使用DataSource的多态，因为DataSource没有set方法
        ComboPooledDataSource ds = new ComboPooledDataSource();
        ds.setJdbcUrl("jdbc:mysql://localhost:3306/mydbtest");
        ds.setUser("root");
        ds.setPassword("123456");
        jdbcTemplate.setDataSource(ds);

        // 第二个参数，需要传入Student类的字节码对象作为参数，也就是查询结果的封装类
        List<Student> students = jdbcTemplate.query("select * from student",
                new BeanPropertyRowMapper<>(Student.class));
        for(Student s: students){
            System.out.println(s);
        }
    }
}

class Helper extends JdbcDaoSupport{
    private DataSource ds;
    private DriverManagerDataSource dmDataSource = new DriverManagerDataSource();
    public JdbcTemplate jdbcTemplate = new JdbcTemplate();

    public Helper(){
        dmDataSource.setUrl("jdbc:mysql://localhost:3306/mydbtest");
        dmDataSource.setUsername("root");
        dmDataSource.setPassword("123456");
        jdbcTemplate.setDataSource(dmDataSource);
    }
}
