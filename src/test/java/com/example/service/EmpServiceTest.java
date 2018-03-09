package com.example.service;

import com.example.domain.Emp;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class EmpServiceTest {
    private ApplicationContext ctx = null;
    private EmpService empService = null;

    @Before
    public void before() {
        ctx = new ClassPathXmlApplicationContext("beans-jpa.xml");
        empService = ctx.getBean(EmpService.class);
        System.out.println("before...");
    }
    @After
    public void after() {
        System.out.println("after...");
    }

    @Test
    public void testUpdateAgeById() {
        empService.updateAgeById(2, 16);
    }

    @Test
    public void testSave() {
        List<Emp> emps = new ArrayList<Emp>();
        for (int i = 0; i < 100; i++) {
            emps.add(new Emp("NO"+Math.floor(Math.random()*1000), new Date(), i));
        }
        empService.save(emps);
    }
}