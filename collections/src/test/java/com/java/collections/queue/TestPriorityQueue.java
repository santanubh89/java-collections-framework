package com.java.collections.queue;

import com.java.collections.model.Employee;
import com.java.collections.model.Student;
import com.java.collections.service.EmployeeService;
import com.java.collections.service.StudentService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.util.PriorityQueue;

@Slf4j
public class TestPriorityQueue {

    @Test
    public void testPriorityQueue() {
        PriorityQueue<Student> studentQueue = new PriorityQueue<>(StudentService.students());
        while(!studentQueue.isEmpty()) {
            Student student = studentQueue.poll();
            log.info("Processing student: {}", student);
        }
    }

    @Test
    public void testPriorityQueueCustomComparison() {
        // Priority Queue based on Employee Salary
        log.info("---- Priority Queue based on Employee Salary ----");
        PriorityQueue<Employee> employeeQueue = new PriorityQueue<>((emp1, emp2) -> emp1.getSalary() - emp2.getSalary());
        employeeQueue.addAll(EmployeeService.employees());
        while(!employeeQueue.isEmpty()) {
            Employee employee = employeeQueue.poll();
            log.info("Processing employee: {}", employee);
        }

        // Priority Queue based on Employee Name
        log.info("---- Priority Queue based on Employee Name ----");
        employeeQueue = new PriorityQueue<>((emp1, emp2) -> emp1.getName().compareTo(emp2.getName()));
        employeeQueue.addAll(EmployeeService.employees());
        while(!employeeQueue.isEmpty()) {
            Employee employee = employeeQueue.peek();
            log.info("Processing employee: {}", employee);
            employeeQueue.remove();
        }
    }

}
