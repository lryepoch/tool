package compare.ex2;

/**
 * @author lryepoch
 * @date 2019/12/24 8:47
 * @description  内部比较器
 */
public class Employee implements Comparable<Employee> {
    private int id;//员工编号
    private double salary;//员工薪资

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public Employee(int id, double salary) {
        super();
        this.id = id;
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "id:" + id + ",salary:" + salary;
    }

    //比较此对象与指定对象的顺序
    public int compareTo(Employee o) {
        int result = this.id > o.id ? 1 : (this.id == o.id ? 0 : -1);
        if (result == 0) {
            result = this.salary > o.salary ? 1 : (this.salary == o.salary ? 0 : -1);
        }
        return result;
    }
}
