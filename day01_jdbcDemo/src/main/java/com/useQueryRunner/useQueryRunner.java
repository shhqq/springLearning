package com.useQueryRunner;

/**
 * Created by s on 2020/6/18 15:43.
 */

import com.domain.Student;
import com.mchange.v2.c3p0.ComboPooledDataSource;
import com.mchange.v2.c3p0.DriverManagerDataSource;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.util.List;

/**
 * java连接数据库的第三种方式：使用QueryRunner
 * QueryRunner存在于org.apache.commons.dbutils中，因此需要依赖common-dbutils
 */
public class useQueryRunner {

    public static void main(String[] args) throws Exception{
        queryRunnerTest1();
        queryRunnerTest2();
    }

    /**
     * 使用ComboPooledDataSource作为数据源
     * @throws Exception
     */
    public static void queryRunnerTest1() throws Exception{
        System.out.println("QueryRunner 使用ComboPooledDataSource");

        // 需要使用set设置四个要素，不能使用DataSource的多态，因为DataSource没有set方法
        ComboPooledDataSource ds = new ComboPooledDataSource();
        ds.setJdbcUrl("jdbc:mysql://localhost:3306/mydbtest");
        ds.setUser("root");
        ds.setPassword("123456");

        // QueryRunner没有set数据源的方法，使用构造函数
        QueryRunner runner = new QueryRunner(ds);
        List<Student> students = runner.query("select * from student", new BeanListHandler<>(Student.class));
        for(Student s: students){
            System.out.println(s);
        }
    }

    /**
     * 使用DriverManagerDataSource作为数据源
     * @throws Exception
     */
    public static void queryRunnerTest2() throws Exception{
        System.out.println("QueryRunner 使用DriverManagerDataSource");

        // 需要使用set设置四个要素，不能使用DataSource的多态，因为DataSource没有set方法
        DriverManagerDataSource ds = new DriverManagerDataSource();
        ds.setJdbcUrl("jdbc:mysql://localhost:3306/mydbtest");
        ds.setUser("root");
        ds.setPassword("123456");

        QueryRunner runner = new QueryRunner(ds);
        List<Student> students = runner.query("select * from student", new BeanListHandler<>(Student.class));
        for(Student s: students){
            System.out.println(s);
        }
    }
}
