package com.base.compare.ex2;

import java.util.Comparator;

/**
 * @author lryepoch
 * @date 2020/1/9 19:05
 * @description  外部比较器，自定义类实现Comparator接口
 */
class EmployeeComparable implements Comparator<Employee> {
    public int compare(Employee o1, Employee o2) {
        int result = o1.getId() > o2.getId() ? 1 : (o1.getId() == o2.getId() ? 0 : -1);
        //如果编号相等，则比较薪资
        if (result == 0) {
            result = o1.getSalary() > o2.getSalary() ? 1 : (o1.getSalary() == o2.getSalary() ? 0 : -1);
        }
        return result;
    }
}