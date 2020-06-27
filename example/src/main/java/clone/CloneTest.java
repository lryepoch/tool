package clone;

/**
 * @author lryepoch
 * @date 2020/6/4 14:07
 * @description TODO 克隆
 */
public class CloneTest {
    public static void main(String[] args) throws CloneNotSupportedException {

        //浅克隆
        Student student1 = new Student("glj", 23);
        Student student2 = (Student) student1.clone();
        student2.setName("gggg");
        System.out.println("student1：" + student1.getName() + " " + student1.getAge());
        System.out.println("student2：" + student2.getName() + " " + student2.getAge());
        System.out.println("==========================");

        //深克隆
        Student s1 = new Student();
        s1.setName("张三");
        s1.setAge(20);

        Teacher teacher1 = new Teacher();
        teacher1.setName("小赵老师");
        teacher1.setStudent(s1);

        Teacher teacher2 = (Teacher) teacher1.clone();
        teacher2.setName("小明老师");

        Student s2 = teacher2.getStudent();
        s2.setName("李四");
        s2.setAge(30);

        System.out.println("teacher1:" + teacher1);
        System.out.println("teacher2:" + teacher2);

    }
}
