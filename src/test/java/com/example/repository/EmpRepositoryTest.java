package com.example.repository;

import com.example.domain.Emp;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.ArrayList;
import java.util.List;

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
    @Test
    public void testfindByNameStartingWithAndAgeLessThan() {
        List<Emp> list = empRepository.findByNameStartingWithAndAgeLessThan("老", 8);
        System.out.println(list);
    }
    @Test
    public void testfindByNameEndtingWithAndAgeLessThan() {
        List<Emp> list = empRepository.findByNameEndingWithAndAgeLessThan("六", 8);
        System.out.println(list);
    }
    @Test
    public void testFindByNameInOrAgeLessThan() {
        List<String> names = new ArrayList<String>();
        names.add("老五");
        names.add("小七");
        List<Emp> list = empRepository.findByNameInOrAgeLessThan(names, 2);
        System.out.println(list);
    }
    @Test
    public void testFindByNameInAndAgeLessThan() {
        List<String> names = new ArrayList<String>();
        names.add("老五");
        names.add("小七");
        List<Emp> list = empRepository.findByNameInAndAgeLessThan(names, 7);
        System.out.println(list);
    }
    @Test
    public void testGetEmpByMaxId() {
        Emp emp = empRepository.getEmpByMaxId();
        System.out.println(emp);
    }
    @Test
    public void testGetEmpByParam() {
        List<Emp> list = empRepository.getEmpByParam("小七", 7);
        System.out.println(list);
    }
    @Test
    public void testGetEmpByParam1() {
        List<Emp> list = empRepository.getEmpByParam1("小七", 7);
        System.out.println(list);
    }
    @Test
    public void testGetEmpByParam2() {
        List<Emp> list = empRepository.getEmpByParam2("小");
        System.out.println(list);
    }
    @Test
    public void testGetEmpByParam3() {
        List<Emp> list = empRepository.getEmpByParam3("小");
        System.out.println(list);
    }
    @Test
    public void testGetCount() {
        Long count = empRepository.getCount();
        System.out.println(count);
    }
    @Test
    public void testUpdateAgeById() {
        empRepository.updateAgeById(2, 16);
    }
}