package base;

/**
 * @author lryepoch
 * @date 2020/12/3 15:30
 * @description TODO Java 允许对象的一个成员直接调用另一个成员，可以省略 this 前缀。
 *                      static 修饰的方法中不能使用 this 引用。并且 Java 语法规定，静态成员不能直接访问非静态成员。
 *                      this修饰成员变量、成员方法、构造方法
 */
public class ThisTest {
    // 定义一个jump()方法
    public void jump() {
        System.out.println("正在执行jump方法");
    }

    // 定义一个run()方法，run()方法需要借助jump()方法
    public void run() {
        this.jump();
        System.out.println("正在执行 run 方法");
    }

    public static void main(String[] args) {

    }
}