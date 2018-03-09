package com.example.util;

import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

/**
 * JDBC 工具类
 * 1、获取Connection
 * 2、释放资源
 */
public class JDBCUtil {

    public static Connection getConnection() throws Exception {
        /**
         * 不建议把配置硬编码到代码中
         *
         * 最佳实践 建议写到配置文件中
         */
//        String url = "jdbc:mysql:///spring-data-demo";
//        String username = "root";
//        String password = "8888";
//        String driverClass = "com.mysql.jdbc.Driver";

        InputStream inputStream = JDBCUtil.class.getClassLoader().getResourceAsStream("db.properties");
        Properties properties = new Properties();
        properties.load(inputStream);

        String url = properties.getProperty("jdbc.url");
        String username = properties.getProperty("jdbc.username");
        String password = properties.getProperty("jdbc.password");
        String driverClass = properties.getProperty("jdbc.driverClass");

        Class.forName(driverClass);
        Connection connection = DriverManager.getConnection(url, username, password);
        return connection;
    }

    /**
     * 释放相关资源
     * @param resultSet
     * @param statement
     * @param connection
     */
    public static void release(ResultSet resultSet, Statement statement, Connection connection) {
        if (resultSet != null) {
            try {
                resultSet.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (statement != null) {
            try {
                statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
