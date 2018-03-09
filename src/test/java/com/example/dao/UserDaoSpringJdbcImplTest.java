package com.example.dao;

import com.example.domain.User;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class UserDaoSpringJdbcImplTest {
    private ApplicationContext ctx = null;
    private UserDao userDao = null;

    @Before
    public void before() {
        ctx = new ClassPathXmlApplicationContext("beans.xml");
        userDao = (UserDao) ctx.getBean("userDao");
        System.out.println("before...");
    }
    @After
    public void after() {
        ctx = null;
        System.out.println("after...");
    }

    @Test
    public void testQuery() {
        List<User> list = userDao.query();
        for (User item: list) {
            System.out.println(item.toString());
        }
    }

    @Test
    public void testSave() {
        User user = new User();
        user.setName("辛德拉");
        user.setAge(36);
        userDao.save(user);
    }
}