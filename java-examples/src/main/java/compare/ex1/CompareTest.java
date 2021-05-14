package compare.ex1;

import java.util.*;

/**
 * @author lryepoch
 * @date 2019/12/23 17:07
 * @description 外部比较器
 */
public class CompareTest {
    public static void main(String[] args) {

        /**
         * 集合
         **/
        List<Student> list = new ArrayList<Student>();
        list.add(new Student(15, "张三"));
        list.add(new Student(13, "李四"));
        list.add(new Student(18, "王五"));
        list.add(new Student(6, "小刘"));

        //外部比较器(匿名内部类)
        Collections.sort(list, new Comparator<Student>() {
            public int compare(Student o1, Student o2) {
                int i = String.valueOf(o1.name).compareTo(String.valueOf(o2.name));
                return i;
            }
        });
        System.out.println("--------集合输出-------");
        for (Student s : list) {
            System.out.println(s);
        }



        /**
         * 最大值
         */
        Student student = Collections.max(list, new Comparator<Student>() {
            public int compare(Student o1, Student o2) {
                int i = Double.valueOf(o1.id).compareTo(Double.valueOf(o2.id));
                return i;
            }
        });
        System.out.println("--------输出最大值-------");
        System.out.println(student);



        /**
         * 数组
         **/
        Student[] student1 = new Student[3];
        student1[0] = new Student(15, "张三");
        student1[1] = new Student(16, "李四");
        student1[2] = new Student(17, "er");

        Arrays.sort(student1, new Comparator<Student>() {
            public int compare(Student o1, Student o2) {
                int i = Double.valueOf(o1.id).compareTo(Double.valueOf(o2.id));
                return i;
            }
        });
        System.out.println("---------数组输出---------");
        for (Student s : student1) {
            System.out.println(s);
        }
    }
}