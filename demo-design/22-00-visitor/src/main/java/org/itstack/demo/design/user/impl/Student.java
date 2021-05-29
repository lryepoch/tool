package org.itstack.demo.design.user.impl;

import org.itstack.demo.design.user.User;
import org.itstack.demo.design.visitor.Visitor;

/**
* 实现用户信息(老师和学生)
*/
// 学生
public class Student extends User {

    public Student(String name, String identity, String clazz) {
        super(name, identity, clazz);
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public int ranking() {
        return (int) (Math.random() * 100);
    }

}
