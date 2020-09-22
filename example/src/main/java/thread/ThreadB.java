package thread;

/**
* @description 数据共享，可能出现线程安全问题
* @author lryepoch
* @date 2020/7/29 13:49
*
*/
public class ThreadB extends Thread {

    private int count = 5;

    @Override
    synchronized public void run() {
        count--;
        System.out.println("由" + this.currentThread().getName() + "计算,count=" + count);
    }

    public static void main(String[] args) {
        ThreadB threadB = new ThreadB();
        Thread a = new Thread(threadB, "A");
        Thread b = new Thread(threadB, "B");
        Thread c = new Thread(threadB, "C");
        Thread d = new Thread(threadB, "D");
        Thread e = new Thread(threadB, "E");

        a.start();
        b.start();
        c.start();
        d.start();
        e.start();
    }
}
