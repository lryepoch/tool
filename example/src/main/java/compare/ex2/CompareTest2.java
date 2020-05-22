package compare.ex2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author lryepoch
 * @date 2019/12/24 8:34
 * @description 同时实现内部比较器和外部比较器，
 *              因为定义的比较规则一样，所以输出结果一样
 *
 *              实体：Employee.java和EmployeeComparable.java
 */
public class CompareTest2 {
    public static void main(String[] args) {
        List<Employee> employees = new ArrayList<Employee>();
        employees.add(new Employee(2, 5000));
        employees.add(new Employee(1, 4500));
        employees.add(new Employee(4, 3500));
        employees.add(new Employee(5, 3000));
        employees.add(new Employee(4, 4000));

        //内部比较器：要排序的对象要求实现了comparable接口
        System.out.println("通过内部比较器实现：");
        Collections.sort(employees);
        System.out.println(employees);

        List<Employee> employees2 = new ArrayList<Employee>();
        employees2.add(new Employee(2, 5000));
        employees2.add(new Employee(1, 4500));
        employees2.add(new Employee(4, 3500));
        employees2.add(new Employee(5, 3000));
        employees2.add(new Employee(4, 4000));

        //外部比较器，自定义类实现Comparator接口
        System.out.println("通过外部比较器实现:");
        Collections.sort(employees2, new EmployeeComparable());
        System.out.println(employees2);
    }
}