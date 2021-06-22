package com.base.clone;

/**
 * @author lryepoch
 * @date 2020/6/4 14:13
 * @description TODO 深克隆
 */
public class Teacher implements Cloneable{

    private String name;
    private Student student;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "name='" + name + '\'' +
                ", student=" + student +
                '}';
    }

    public Object clone() throws CloneNotSupportedException {
        Teacher teacher= (Teacher) super.clone();
        teacher.setStudent((Student) teacher.getStudent().clone());
        return teacher;
    }

}
