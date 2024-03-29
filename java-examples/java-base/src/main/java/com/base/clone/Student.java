package com.base.clone;

/**
 * @author lryepoch
 * @date 2020/6/4 14:08
 * @description TODO
 */
public class Student implements Cloneable {
    private String name;
    private int age;

    public Student() {
    }

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

}
