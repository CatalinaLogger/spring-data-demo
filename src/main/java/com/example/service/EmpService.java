package com.example.service;

import com.example.domain.Emp;
import com.example.repository.EmpCrudRepository;
import com.example.repository.EmpRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class EmpService {

    @Autowired
    private EmpRepository empRepository;
    @Autowired
    private EmpCrudRepository empCrudRepository;

    @Transactional
    public void updateAgeById(Integer id, Integer age) {
        empRepository.updateAgeById(id, age);
    }
    @Transactional
    public void save(List<Emp> emps) {
        empCrudRepository.save(emps);
    }
}
