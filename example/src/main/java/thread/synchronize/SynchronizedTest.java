package thread.synchronize;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 测试synchronized关键字
 */
public class SynchronizedTest {

    public static String now() {
        return new SimpleDateFormat("HH:mm:ss").format(new Date());
    }

    public static void main(String[] args) {
        final Object someObject = new Object();

        Thread t1 = new Thread() {
            public void run() {
                try {
                    System.out.println(now() + " t1 begin ");
                    System.out.println("synchronized外 " + now() + this.getName() + " t1~someObject");
                    synchronized (someObject) {
                        System.out.println("# synchronized内 " + now() + this.getName() + " t1~someObject");
                        Thread.sleep(5000);
                        System.out.println("# synchronized内，sleep后 " + now() + this.getName() + " t1~someObject");
                    }
                    System.out.println(now() + " t1 stop ");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        t1.setName("T1");
        t1.start();

        Thread t2 = new Thread() {
            public void run() {
                try {
                    System.out.println(now() + " t2 begin ");
                    System.out.println("synchronized外 " + now() + this.getName() + " t2~someObject");
                    synchronized (someObject) {
                        System.out.println("* synchronized内 " + now() + this.getName() + " t2~someObject");
                        Thread.sleep(5000);
                        System.out.println("* synchronized内，sleep后 " + now() + this.getName() + " t2~someObject");
                    }
                    System.out.println(now() + " t2 stop ");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        t2.setName("T2");
        t2.start();
    }

}
