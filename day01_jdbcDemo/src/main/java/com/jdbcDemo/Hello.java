package com.jdbcDemo;

import java.sql.*;

/**
 * Created by s on 2020/6/2 14:06.
 * 测试数据库连接
 * 首先手动添加mysql-connector-cj-jdbc-Driver驱动或者通过maven添加配置进行导包
 */
public class Hello {
    // MySQL驱动包名
    // 从mysql-connector-java 5.x之后，数据库驱动变为com.mysql.cj.jdbc.Driver
    // private static final String DRIVER_NAME = "com.mysql.jdbc.Driver";
     private static final String DRIVER_NAME = "com.mysql.cj.jdbc.Driver";
    // 数据库连接地址
    private static final String URL = "jdbc:mysql://localhost:3306/mydbtest?serverTimezone=GMT%2B8";
    // 用户名
    private static final String USER_NAME = "root";
    // 密码
    private static final String PASSWORD = "123456";

    public static void main(String[] args) {
        mysqlTest01();
//        mysqlTest02();
        mysqlTest03();
    }

    /**
     * 使用封装的DBHelper，简化过程
     */
    private static void mysqlTest03(){
        String sql = "Select * from student";
        DBHelper db = new DBHelper(sql);
        try{
            ResultSet rs = db.st.executeQuery();
            while (rs.next()){
                System.out.println(rs.getInt(1) + " " + rs.getString(2));
            }
            rs.close();
            db.close();
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    /**
     * mysql 创建表，并插入数据
     */
    private static void mysqlTest02(){
        Connection conn = null;
        try{
            conn = DriverManager.getConnection(URL, USER_NAME, PASSWORD);
            String sql = "create table Teacher(no int, name char(10))";
            Statement ps = conn.createStatement();
            int result = ps.executeUpdate(sql);
            if(result != -1){
                sql = "insert into Teacher(no, name) values(2001, 'Lily')";
                result = ps.executeUpdate(sql);
                sql = "insert into Teacher(no, name) values(2002, 'Michel')";
                result = ps.executeUpdate(sql);
                sql = "select * from Teacher";
                ResultSet rs = ps.executeQuery(sql);
                while (rs.next()){
                    System.out.println(rs.getInt("no") + " " + rs.getString("name"));
                }
                rs.close();
                ps.close();
            }
        } catch (Exception e){
            e.printStackTrace();
        } finally {
            if(conn != null){
                try{
                    conn.close();
                } catch (SQLException e){
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * mysql 查询表，并遍历结果
     */
    private static void mysqlTest01(){
        Connection conn = null;
        try{
            // 加载MySQL的驱动类
            // Class.forName(DRIVER_NAME);
            // 获取数据库连接
            conn = DriverManager.getConnection(URL, USER_NAME, PASSWORD);
            // mysql查询语句
            String sql = "select * from student";
            // String sql = "insert student(id, name) values (1003, \"Michel\")";
            PreparedStatement prst = conn.prepareStatement(sql);
            // 结果集
            ResultSet rs = prst.executeQuery();

            while (rs.next()){
                System.out.println("id: " + rs.getInt("id") + ", name: " + rs.getString("name"));
            }
            rs.close();
            prst.close();
        } catch (Exception e){
            e.printStackTrace();
        } finally {
            if(conn != null){
                try{
                    conn.close();
                } catch (SQLException e){
                    e.printStackTrace();
                }
            }
        }
    }
}
