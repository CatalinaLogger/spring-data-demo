package com.example.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

/**
 * 雇员
 */
@Entity
public class Emp {
    @Id
    @GeneratedValue
    private Integer id;
    @Column(length = 20)
    private String name;
    @Column(nullable = false)
    private Date brith;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getBrith() {
        return brith;
    }

    public void setBrith(Date brith) {
        this.brith = brith;
    }

    @Override
    public String toString() {
        return "Emp{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", brith=" + brith +
                '}';
    }
}
