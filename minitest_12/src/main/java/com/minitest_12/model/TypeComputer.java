package com.minitest_12.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "type_computers")
public class TypeComputer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @OneToMany(targetEntity = Computer.class)
    private List<Computer> computers;

    public TypeComputer() {
    }

    public TypeComputer(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Computer> getComputers() {
        return computers;
    }

    public void setComputers(List<Computer> computers) {
        this.computers = computers;
    }
}
