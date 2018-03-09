package com.example.repository;

import com.example.domain.Emp;
import org.springframework.data.repository.Repository;

public interface EmpRepository extends Repository<Emp, Integer> {

    Emp findByName(String name);
}
