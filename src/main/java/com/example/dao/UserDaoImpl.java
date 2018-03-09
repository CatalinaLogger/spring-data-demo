package com.example.dao;

import com.example.domain.User;
import com.example.util.JDBCUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 * 用户Dao (JDBC实现)
 */
public class UserDaoImpl implements UserDao {

    public List<User> query() {
        List<User> list = new ArrayList<User>();
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        String sql = "select * from user";
        try {
            connection = JDBCUtil.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                int age = resultSet.getInt("age");
                User user = new User();
                user.setId(id);
                user.setName(name);
                user.setAge(age);
                list.add(user);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.release(resultSet, preparedStatement, connection);
        }
        return list;
    }

    public void save(User user) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        String sql = "insert into user (name, age) values (?, ?)";
        try {
            connection = JDBCUtil.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, user.getName());
            preparedStatement.setInt(2, user.getAge());
            preparedStatement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.release(resultSet, preparedStatement, connection);
        }
    }
}
