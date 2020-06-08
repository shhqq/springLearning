package com.springLearn.utils;

/**
 * Created by s on 2020/6/8 14:20.
 */

import javax.sql.DataSource;
import java.sql.Connection;

/**
 * 连接的工具类，用来从数据源中获取一个连接， 并且实现与线程的绑定
 */
public class ConnectionUtils {

    private ThreadLocal<Connection> tl = new ThreadLocal<>();

    // 数据源，需要一个set方法，由spring的容器注入
    private DataSource dataSource;

    /**
     * dataSource的set方法
     * @param dataSource    DataSource
     */
    public void setDataSource(DataSource dataSource){
        this.dataSource = dataSource;
    }

    /**
     * 从ThreadLocal中获取连接
     * @return  连接
     */
    public Connection getThreadConnection(){
        try {
            // 1. 先从ThreadLocal中获取连接
            Connection conn = tl.get();
            // 2. 判断连接是否为空，即当前线程时候有连接
            if (conn == null) {
                // 3. 如果没有，就从数据源获取一个连接，并且存入ThreadLocal中，即与当前线程绑定
                conn = dataSource.getConnection();
                tl.set(conn);
            }
            // 4. 返回当前线程上的连接
            return conn;
        } catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    /**
     * 将当前线程与连接解绑
     */
    public void removeConnection(){
        tl.remove();
    }
}
