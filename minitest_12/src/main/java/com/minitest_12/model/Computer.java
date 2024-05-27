package com.minitest_12.model;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Component
@Entity
@Table(name = "computers")
public class Computer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Code cannot be empty")
    @Pattern(regexp = "^CG\\d{6}$", message = "Code must start with CG and have a maximum of 8 characters")
    private String code;

    @NotBlank(message = "Name cannot be empty")
    @Size(max = 50, message = "Name cannot exceed 50 characters")
    private String name;

    @NotBlank(message = "Producer cannot be empty")
    private String producer;

    @ManyToOne
    @JoinColumn(name = "producer_id")
    private TypeComputer typeComputer;

    public Computer() {
    }

    public Computer(String code, String name, String producer) {
        this.code = code;
        this.name = name;
        this.producer = producer;
    }

    public Computer(String code, String name, String producer, TypeComputer typeComputer) {
        this.code = code;
        this.name = name;
        this.producer = producer;
        this.typeComputer = typeComputer;
    }

    public Computer(Long id, String code, String name, String producer, TypeComputer typeComputer) {
        this.id = id;
        this.code = code;
        this.name = name;
        this.producer = producer;
        this.typeComputer = typeComputer;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProducer() {
        return producer;
    }

    public void setProducer(String producer) {
        this.producer = producer;
    }

    public TypeComputer getTypeComputer() {
        return typeComputer;
    }

    public void setTypeComputer(TypeComputer typeComputer) {
        this.typeComputer = typeComputer;
    }

//    @Override
//    public boolean supports(Class<?> clazz) {
//        return Computer.class.isAssignableFrom(clazz);
//    }
//
//    @Override
//    public void validate(Object target, Errors errors) {
//        Computer computer = (Computer) target;
//
//        if (computer.getCode() == null || computer.getCode().isEmpty()) {
//            errors.rejectValue("code", "code.empty");
//        } else if (!Pattern.matches("^CG.*$", computer.getCode()) || computer.getCode().length() > 8) {
//            errors.rejectValue("code", "code.invalid");
//        }
//
//        if (computer.getName() == null || computer.getName().isEmpty()) {
//            errors.rejectValue("name", "name.empty");
//        }
//
//        if (computer.getProducer() == null || computer.getProducer().isEmpty()) {
//            errors.rejectValue("producer", "producer.empty");
//        }
//    }
}
