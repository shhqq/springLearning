package com.jdbcDemo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Created by s on 2020/6/2 16:00.
 *
 * 尝试封装连接
 */

public class DBHelper {
    private static final String URL = "jdbc:mysql://localhost:3306/mydbtest?serverTimezone=GMT%2B8";
    private static final String USER_NAME = "root";
    private static final String PASSWORD = "123456";
    public static PreparedStatement st;
    private String sql;
    private Connection conn;

    // 不提供无参constructor
//    public DBHelper(){
//        try{
//            conn = DriverManager.getConnection(URL, USER_NAME, PASSWORD);
//            st = conn.createStatement();
//        } catch(Exception e){
//            e.printStackTrace();
//        }
//    }

    /**
     * constructor method.
     * @param sql   SQL statement.
     */
    public DBHelper(String sql){
        this.sql = sql;
        try{
            // 连接数据库
            conn = DriverManager.getConnection(URL, USER_NAME, PASSWORD);
            // 创建SQL对象
            st = conn.prepareStatement(sql);
        } catch(Exception e){
            e.printStackTrace();
        }
    }

    /**
     * close the connection of database.
     */
    public void close(){
        if(conn != null){
            try{
                conn.close();
            } catch (SQLException e){
                e.printStackTrace();
            }
        }
    }
}
