package com.example.dao;

import com.example.domain.User;
import org.junit.Test;

import java.util.List;

public class UserDaoImplTest {

    @Test
    public void testQuery() {
       UserDaoImpl userDao = new UserDaoImpl();
        List<User> list = userDao.query();
        for (User item: list) {
            System.out.println(item.toString());
        }
    }

    @Test
    public void testSave() {
        UserDaoImpl userDao = new UserDaoImpl();
        User user = new User();
        user.setName("拉克丝");
        user.setAge(18);
        userDao.save(user);
    }
}