package com.example.repository;

import com.example.domain.Emp;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class EmpRepositoryTest {
    private ApplicationContext ctx = null;
    private EmpRepository empRepository = null;

    @Before
    public void before() {
        ctx = new ClassPathXmlApplicationContext("beans-jpa.xml");
        empRepository = ctx.getBean(EmpRepository.class);
        System.out.println("before...");
    }
    @After
    public void after() {
        System.out.println("after...");
    }

    @Test
    public void testFindByName() {
        Emp emp = empRepository.findByName("张三");
        System.out.println(emp);
    }
}