package com.java.collections.list;

import com.java.collections.model.Employee;
import com.java.collections.model.Student;
import com.java.collections.service.EmployeeService;
import com.java.collections.service.StudentService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
public class TestCompare {

    @Test
    public void testSort() {
        List<Integer> numbers = new ArrayList<>(List.of(5, 1, 9, 7, 3));
        numbers.sort(null);
        log.info("Sorted List (Asc): {}", numbers);

        numbers = new ArrayList<>(List.of(5, 1, 9, 7, 3));
        numbers.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
        log.info("Sorted List (Desc): {}", numbers);
    }

    @Test
    public void testSortDescending() {
        List<String> items = new ArrayList<>(List.of("banana", "date", "apple", "cherry"));
        items.sort(null);
        log.info("Sorted List (Ascending): {}", items);

        items = new ArrayList<>(List.of("banana", "date", "apple", "cherry"));
        items.sort(Collections.reverseOrder());
        log.info("Sorted List (Descending): {}", items);

        items = new ArrayList<>(List.of("banana", "date", "apple", "cherry"));
        items.sort((a, b) -> b.compareTo(a));
        log.info("Sorted List (Descending): {}", items);
    }

    @Test
    public void testSortCustomClass() {
        List<Employee> employees = EmployeeService.employees();
        log.info("---Before Sorting---");
        String unsorted = employees.stream().map(e -> e.getName()+":"+e.getSalary()).collect(Collectors.joining(", "));
        log.info("Unsorted data: {}", unsorted);

        // Sort by name (Ascending)
        class EmployeeNameComparator implements Comparator<Employee> {
            @Override
            public int compare(Employee o1, Employee o2) {
                return o1.getName().compareTo(o2.getName());
            }
        }

        employees.sort(new EmployeeNameComparator());
        String nameSorted = employees.stream().map(e -> e.getName()+":"+e.getSalary()).collect(Collectors.joining(", "));
        log.info("Name Sorted data: {}", nameSorted);

        // Sort by salary (Descending)
        class EmployeeSalaryComparator implements Comparator<Employee> {
            @Override
            public int compare(Employee o1, Employee o2) {
                if (o1.getSalary() < o2.getSalary()) {
                    return -1;
                }
                else if (o1.getSalary() > o2.getSalary()) {
                    return 1;
                }
                else {
                    return 0;
                }
            }
        }
        employees.sort(new EmployeeSalaryComparator());
        String salarySorted = employees.stream().map(e -> e.getName()+":"+e.getSalary()).collect(Collectors.joining(", "));
        log.info("Salary Sorted data: {}", salarySorted);
    }

    @Test
    public void testSortCustomClassJava8() {
        List<Employee> employees = EmployeeService.employees();
        log.info("---Before Sorting---");
        String unsorted = employees.stream().map(e -> e.getName()+":"+e.getSalary()).collect(Collectors.joining(", "));
        log.info("Unsorted data: {}", unsorted);

        // Sort by name (Ascending)
        Comparator<Employee> nameComparator = Comparator.comparing(Employee::getName);
        employees.sort(nameComparator);
        String nameSorted = employees.stream().map(e -> e.getName()+":"+e.getSalary()).collect(Collectors.joining(", "));
        log.info("Name Sorted data: {}", nameSorted);

        // Sort by salary (Descending)
        Comparator<Employee> salaryComparator = Comparator.comparing(Employee::getSalary).reversed()
                                                            .thenComparing(Employee::getName);
        employees.sort(salaryComparator);
        String salarySorted = employees.stream().map(e -> e.getName()+":"+e.getSalary()).collect(Collectors.joining(", "));
        log.info("Salary Sorted data: {}", salarySorted);
    }

    @Test
    public void testStringLengthComparator() {
        List<String> items = new ArrayList<>(List.of("banana", "fig", "mango", "apple", "cherry", "kiwi"));
        log.info("Before Sorting: {}", items);

        // Sort by string length (Ascending)
        class StringLengthComparator implements Comparator<String> {
            @Override
            public int compare(String o1, String o2) {
                if (o1.length() == o2.length()) {
                    return o1.compareTo(o2); // If lengths are equal, sort alphabetically
                }
                return Integer.compare(o1.length(), o2.length());
            }
        }

        items.sort(new StringLengthComparator());
        log.info("After Sorting by Length (Asc): {}", items);
    }

    @Test
    public void testComparable() {
        List<Student> students = StudentService.students();
        log.info("Before Sorting: {}", students);
        // students.sort(null);
        Collections.sort(students);
        log.info("After Sorting by Marks (Asc): {}", students);
    }

}
