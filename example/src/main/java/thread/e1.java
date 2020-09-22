package thread;

/**
 * @author lryepoch
 * @date 2020/8/18 15:58
 * @description TODO
 */
public class e1 {
    public static void main(String[] args) {
        Thread a = new Thread();
        Thread b = new Thread();
        System.out.println(a.getName());
        System.out.println(b.getName());

        System.out.println(Thread.currentThread().getName());
    }
}
