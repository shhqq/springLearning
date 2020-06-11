package config;

/**
 * Created by s on 2020/6/11 16:16.
 */

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * spring的配置类，相当于bean.xml
 */
@Configuration
@ComponentScan(value = "com.springLearn")
@Import({JdbcConfiguration.class, TransactionConfiguration.class})
@EnableTransactionManagement
public class SpringConfiguration {
}
