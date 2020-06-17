package com.mybatisLearn.mybatis.utils;

/**
 * Created by s on 2020/6/17 15:19.
 */

import com.mybatisLearn.mybatis.config.Configuration;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * 获取一个数据库连接
 */
public class DataSourceUtil {

    /**
     * 根据配置获取一个Connection
     * @param cfg Configuration对象
     * @return 返回一个Connection对象
     */
    public Connection getConnection(Configuration cfg){
        try{
            Class.forName(cfg.getDriver());
            return DriverManager.getConnection(cfg.getUrl(), cfg.getUsername(), cfg.getPassword());
        } catch (Exception e){
            throw new RuntimeException(e);
        }
    }
}
