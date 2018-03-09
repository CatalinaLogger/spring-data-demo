package com.example.repository;


import com.example.domain.Emp;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class EmpJpaRepositoryTest {
    private ApplicationContext ctx = null;
    private EmpJpaRepository empJpaRepository = null;

    @Before
    public void before() {
        ctx = new ClassPathXmlApplicationContext("beans-jpa.xml");
        empJpaRepository = ctx.getBean(EmpJpaRepository.class);
        System.out.println("before...");
    }
    @After
    public void after() {
        System.out.println("after...");
    }

    @Test
    public void testFindOne() {
        Emp one = empJpaRepository.findOne(99);
        System.out.println(one);
        System.out.println("Emp[10]：" + empJpaRepository.exists(10));
        System.out.println("Emp[300]：" + empJpaRepository.exists(300));
    }
}