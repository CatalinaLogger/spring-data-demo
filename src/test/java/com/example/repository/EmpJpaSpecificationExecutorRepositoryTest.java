package com.example.repository;

import com.example.domain.Emp;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.*;

public class EmpJpaSpecificationExecutorRepositoryTest {
    private ApplicationContext ctx = null;
    private EmpJpaSpecificationExecutorRepository empJpaSpecificationExecutorRepository = null;

    @Before
    public void before() {
        ctx = new ClassPathXmlApplicationContext("beans-jpa.xml");
        empJpaSpecificationExecutorRepository = ctx.getBean(EmpJpaSpecificationExecutorRepository.class);
        System.out.println("before...");
    }
    @After
    public void after() {
        System.out.println("after...");
    }

    /**
     * 分页
     * 排序
     * 条件查询
     */
    @Test
    public void testQuery() {
        Sort.Order order = new Sort.Order(Sort.Direction.DESC, "id");
        Sort sort =  new Sort(order);
        // page从0开始
        Pageable pageable = new PageRequest(0, 10, sort);

        Specification<Emp> specification = new Specification<Emp>() {
            public Predicate toPredicate(Root<Emp> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
                Path path = root.get("age");
                return cb.gt(path, 50);
            }
        };
        Page<Emp> page = empJpaSpecificationExecutorRepository.findAll(specification,pageable);

        System.out.println("总页数：" + page.getTotalPages());
        System.out.println("总记录数：" + page.getTotalElements());
        System.out.println("当前页码：" + (page.getNumber() + 1));
        System.out.println("当前页内容：" + page.getContent());
        System.out.println("当前页面记录数：" + page.getNumberOfElements());
    }
}