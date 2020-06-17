package com.mybatisLearn.mybatis.utils;

import com.mybatisLearn.mybatis.config.Configuration;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * Created by s on 2020/6/17 10:26.
 */

/**
 * 获取一个数据库连接
 */
public class DataSourceUtil {

    /**
     * 根据配置获取数据库连接
     * @param cfg 数据库连接相关配置类
     * @return Connection
     */
    public static Connection getConnection(Configuration cfg){
        try {
            Class.forName(cfg.getDriver());
            return DriverManager.getConnection(cfg.getUrl(), cfg.getUsername(), cfg.getPassword());
        } catch (Exception e){
            throw new RuntimeException(e);
        }
    }
}
