package config;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.apache.commons.dbutils.QueryRunner;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;

import javax.sql.DataSource;
import java.beans.PropertyVetoException;

/**
 * Created by s on 2020/6/5 16:00.
 */

/**
 * spring与数据库连接相关的配置类
 */
public class JdbcConfig {

    @Value("${jdbc.driver}")
    private String driver;

    @Value("${jdbc.url}")
    private String url;

    @Value("${jdbc.username}")
    private String username;

    @Value("${jdbc.password}")
    private String password;

    /**
     * 用于创建一个QueryRunner对象
     * @param ds DataSource
     * @return  instance of QueryRunner
     */
    @Bean(name = "runner")
    @Scope("prototype")
    public QueryRunner createQueryRunner(DataSource ds){
        return new QueryRunner(ds);
    }

    /**
     * 用于创建一个DataSource对象
     * @return  instance of DataSource
     */
    @Bean(name = "ds")
    public DataSource createDataSource(){
        ComboPooledDataSource ds = new ComboPooledDataSource();
        try {
//            ds.setDriverClass("com.mysql.cj.jdbc.Driver");
            ds.setDriverClass(driver);
        } catch (PropertyVetoException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
//        ds.setJdbcUrl("jdbc:mysql://localhost:3306/mydbtest");
//        ds.setUser("root");
//        ds.setPassword("123456");

        // 改为使用配置文件
        ds.setJdbcUrl(url);
        ds.setUser(username);
        ds.setPassword(password);
        return ds;
    }
}
