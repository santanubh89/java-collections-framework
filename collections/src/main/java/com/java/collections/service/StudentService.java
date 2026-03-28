package com.java.collections.service;

import com.java.collections.model.Student;
import java.util.ArrayList;
import java.util.List;

public class StudentService {

    public static List<Student> students() {
        Student s1 = Student.builder().id(1).name("Amit").marks(88.5).build();
        Student s2 = Student.builder().id(2).name("Sara").marks(92.0).build();
        Student s3 = Student.builder().id(3).name("Li Wei").marks(76.3).build();
        Student s4 = Student.builder().id(4).name("Franc").marks(84.7).build();
        Student s5 = Student.builder().id(5).name("John").marks(69.2).build();
        Student s6 = Student.builder().id(6).name("Priya").marks(95.1).build();
        Student s7 = Student.builder().id(7).name("Alex").marks(81.0).build();
        List<Student> data = List.of(s1, s2, s3, s4, s5, s6, s7);
        return new ArrayList<>(data);
    }

}

