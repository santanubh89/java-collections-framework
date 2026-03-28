package com.java.collections.model;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Student implements Comparable<Student> {

    private int id;

    private String name;

    private double marks;

    @Override
    public int compareTo(Student other) {
        if (other.marks -  this.marks > 0) return 1;
        else if (other.marks - this.marks < 0) return -1;
        else return 0;
    }

    @Override
    public String toString() {
        return id+"_"+name+"_"+marks;
    }
}
