package com.example.dao;

import com.example.domain.User;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowCallbackHandler;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * 用户Dao (Spring jdbc 实现)
 */
public class UserDaoSpringJdbcImpl implements UserDao{

    private JdbcTemplate jdbcTemplate;

    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<User> query() {
        final List<User> list = new ArrayList<User>();
        String sql = "select * from user";
        jdbcTemplate.query(sql, new RowCallbackHandler() {
            public void processRow(ResultSet rs) throws SQLException {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                int age = rs.getInt("age");
                User user = new User();
                user.setId(id);
                user.setName(name);
                user.setAge(age);
                list.add(user);
            }
        });
        return list;
    }

    public void save(User user) {
        String sql = "insert into user (name, age) values (?, ?)";
        jdbcTemplate.update(sql, new Object[]{user.getName(), user.getAge()});
    }
}
