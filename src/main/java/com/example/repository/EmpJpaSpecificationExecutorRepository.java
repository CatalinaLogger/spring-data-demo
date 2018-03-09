package com.example.repository;

import com.example.domain.Emp;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface EmpJpaSpecificationExecutorRepository extends JpaRepository<Emp, Integer>, JpaSpecificationExecutor<Emp> {
}
