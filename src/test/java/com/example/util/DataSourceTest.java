package com.example.util;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.util.Assert;

import javax.sql.DataSource;

public class DataSourceTest {

    private ApplicationContext ctx = null;

    @Before
    public void before() {
        ctx = new ClassPathXmlApplicationContext("beans.xml");
        System.out.println("before...");
    }
    @After
    public void after() {
        ctx = null;
        System.out.println("after...");
    }
    @Test
    public void testDataSource() {
        System.out.println("loading...");
        DataSource dataSource = (DataSource) ctx.getBean("dataSource");
        Assert.notNull(dataSource);
    }

    @Test
    public void testJdbcTemplate() {
        System.out.println("loading...");
        JdbcTemplate jdbcTemplate = (JdbcTemplate) ctx.getBean("jdbcTemplate");
        Assert.notNull(jdbcTemplate);
    }
}
