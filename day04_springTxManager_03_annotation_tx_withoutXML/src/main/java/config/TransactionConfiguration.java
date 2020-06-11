package config;

/**
 * Created by s on 2020/6/11 16:33.
 */

import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;

/**
 * 事务管理配置类
 */
public class TransactionConfiguration {

    /**
     * 创建DataSourceTransactionManager对象，并使用Bean注解将其加入到spring容器中
     * @param dataSource    DataSource， 在JdbcConfiguration中已经进行了配置
     * @return  instance of DataSourceTransactionManager
     */
    @Bean("txManager")
    private DataSourceTransactionManager createDataSourceTransactionManager(DataSource dataSource){
        return new DataSourceTransactionManager(dataSource);
    }

    /**
     * 也可以使用这个方法创建DataSourceTransactionManager对象
     * @param dataSource
     * @return
     */
    public PlatformTransactionManager createTransactionManager(DataSource dataSource){
        return new DataSourceTransactionManager(dataSource);
    }
}
