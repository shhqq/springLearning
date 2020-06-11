package config;

/**
 * Created by s on 2020/6/11 16:18.
 */

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

/**
 * jdbc连接相关配置
 */
@PropertySource("classpath:jdbc.properties")    //配置文件路径，该配置也可以放在主配置类中。classpath关键字表示是类路径，可以省略
public class JdbcConfiguration {

    @Value("${jdbc.driver}")
    private String driver;

    @Value("${jdbc.url}")
    private String url;

    @Value("${jdbc.username}")
    private String username;

    @Value("${jdbc.password}")
    private String password;


    /**
     * 创建JdbcTemplate对象，并使用Bean注解将其加入spring容器中。
     * @param dataSource    DataSource，可以使用DriverManagerDataSource
     * @return  JdbcTemplate
     */
    @Bean("jdbcTemplate")
    private JdbcTemplate createJdbcTemplate(DataSource dataSource){
        return new JdbcTemplate(dataSource);
    }

    /**
     * 创建DataSource对象，并使用Bean注解将其加入spring容器中
     * @return  DataSource
     */
    @Bean("dataSource")
    private DataSource createDataSource(){
        // 注意这里要使用DriverManagerDataSource创建对象，否则多态左侧不能调用右侧的方法。
        // DataSource dataSource = new DriverManagerDataSource();

        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(driver);
        dataSource.setUrl(url);
        dataSource.setUsername(username);
        dataSource.setPassword(password);
        return dataSource;
    }
}
