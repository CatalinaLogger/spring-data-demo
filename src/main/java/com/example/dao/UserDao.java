package com.example.dao;

import com.example.domain.User;

import java.util.List;

/**
 * 用户Dao访问接口
 */
public interface UserDao {

    List<User> query();

    void save(User user);
}
