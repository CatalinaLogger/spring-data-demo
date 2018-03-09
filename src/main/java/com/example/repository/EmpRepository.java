package com.example.repository;

import com.example.domain.Emp;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface EmpRepository extends Repository<Emp, Integer> {

    Emp findByName(String name);

    List<Emp> findByNameStartingWithAndAgeLessThan(String name, Integer age);

    List<Emp> findByNameEndingWithAndAgeLessThan(String name, Integer age);

    List<Emp> findByNameInOrAgeLessThan(List<String> names, Integer age);

    List<Emp> findByNameInAndAgeLessThan(List<String> names, Integer age);

    @Query("select o from Emp o where id = (select max(id) from Emp t1)")
    Emp getEmpByMaxId();

    @Query("select o from Emp o where o.name = ?1 and o.age = ?2")
    List<Emp> getEmpByParam(String name, Integer age);

    @Query("select o from Emp o where o.name = :name and o.age = :age")
    List<Emp> getEmpByParam1(@Param("name") String name, @Param("age") Integer age);

    @Query("select o from Emp o where o.name like %?1%")
    List<Emp> getEmpByParam2(String name);

    @Query("select o from Emp o where o.name like %:name%")
    List<Emp> getEmpByParam3(@Param("name") String name);

    @Query(nativeQuery = true, value = "select count(1) from emp")
    Long getCount();

    @Modifying
    @Query("update Emp o set o.age = :age where o.id = :id")
    void updateAgeById(@Param("id") Integer id, @Param("age") Integer age);
}
