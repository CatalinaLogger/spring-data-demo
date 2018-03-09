package com.example.dao;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringDataTest {
    private ApplicationContext ctx = null;

    @Before
    public void before() {
        ctx = new ClassPathXmlApplicationContext("beans-jpa.xml");
        System.out.println("before...");
    }
    @After
    public void after() {
        ctx = null;
        System.out.println("after...");
    }

    @Test
    public void testQuery() {

    }

    @Test
    public void testSave() {

    }
}