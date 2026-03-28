package com.java.collections.service;

import com.java.collections.model.Employee;
import com.java.collections.model.Department;
import com.java.collections.model.Address;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class EmployeeService {

    public static List<Employee> employees() {
        Employee emp1 = Employee.builder()
                .name("Diana")
                .age(30)
                .department(Department.ENGINEERING)
                .salary(95000)
                .skills(Arrays.asList("Java", "Spring", "Docker"))
                .address(Address.builder().city("Kolkata").country("India").build())
                .build();
        Employee emp2 = Employee.builder()
                .name("Carlos")
                .age(40)
                .department(Department.HR)
                .salary(85000)
                .skills(Arrays.asList("Recruitment", "Onboarding"))
                .address(Address.builder().city("London").country("UK").build())
                .build();
        Employee emp3 = Employee.builder()
                .name("Bob")
                .age(28)
                .department(Department.MARKETING)
                .salary(70000)
                .skills(Arrays.asList("SEO", "Content Creation"))
                .address(Address.builder().city("Madrid").country("Spain").build())
                .build();
        Employee emp4 = Employee.builder()
                .name("Alice")
                .age(35)
                .department(Department.SALES)
                .salary(90000)
                .skills(Arrays.asList("Negotiation", "CRM"))
                .address(Address.builder().city("Berlin").country("Germany").build())
                .build();
        Employee emp5 = Employee.builder()
                .name("Frank")
                .age(29)
                .department(Department.LEGAL)
                .salary(92000)
                .skills(Arrays.asList("Contract Law", "Compliance"))
                .address(Address.builder().city("Paris").country("France").build())
                .build();
        Employee emp6 = Employee.builder()
                .name("Eva")
                .age(41)
                .department(Department.ENGINEERING)
                .salary(110000)
                .skills(Arrays.asList("C++", "Microservices"))
                .address(Address.builder().city("Toronto").country("Canada").build())
                .build();
        Employee emp7 = Employee.builder()
                .name("George")
                .age(45)
                .department(Department.ENGINEERING)
                .salary(60000)
                .skills(Arrays.asList("DevOps", "Cloud"))
                .address(Address.builder().city("Bangalore").country("India").build())
                .build();
        List<Employee> data = List.of(emp1, emp2, emp3, emp4, emp5, emp6, emp7);
        return new ArrayList<>(data);
    }

}
