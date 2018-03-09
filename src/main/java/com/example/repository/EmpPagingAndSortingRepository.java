package com.example.repository;

import com.example.domain.Emp;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface EmpPagingAndSortingRepository extends PagingAndSortingRepository<Emp, Integer> {
}
