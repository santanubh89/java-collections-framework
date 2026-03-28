package com.java.collections.model;

import lombok.*;

import java.util.Objects;

@Getter @Setter
@AllArgsConstructor @NoArgsConstructor

public class Person {

    private int id;

    private String name;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (null == o) return false;
        if (getClass() != o.getClass()) return false;
        Person other = (Person) o;
        return id == other.id && name.equals(other.name);
    }


    @Override
    public int hashCode() {
        return Objects.hash(name, id);
        /*
        int result = Integer.hashCode(id);
        result = 31 * result + name.hashCode();
        return result;
        */
    }

    @Override
    public String toString() {
        return id+"::"+name;
    }


}
