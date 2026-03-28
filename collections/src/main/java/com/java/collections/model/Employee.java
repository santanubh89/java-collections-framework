package com.java.collections.model;

import lombok.*;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Employee {

    private String name;

    private int age;

    private Department department;

    private int salary;

    private List<String> skills;

    private Address address;

    @Override
    public String toString() {
        return "Employee_"+name+"_"+age+"_"+department+"_"+salary;
    }

}
