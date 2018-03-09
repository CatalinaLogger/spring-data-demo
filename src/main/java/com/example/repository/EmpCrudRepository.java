package com.example.repository;

import com.example.domain.Emp;
import org.springframework.data.repository.CrudRepository;

public interface EmpCrudRepository extends CrudRepository<Emp, Integer>{
}
