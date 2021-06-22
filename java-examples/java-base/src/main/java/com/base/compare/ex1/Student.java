package com.base.compare.ex1;

/**
 * @author lryepoch
 * @date 2019/12/23 17:00
 * @description CompareTest.java
 */
public class Student {
    int id;
    String name;

    public Student(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return this.id + " " + this.name;
    }
}