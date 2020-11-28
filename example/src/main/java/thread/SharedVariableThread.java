package thread;

/**
 * @description 数据共享，可能出现线程安全问题
 * @author lryepoch
 * @date 2020/7/29 13:49
 *
 */
public class SharedVariableThread extends Thread {

    private int count = 5;

    @Override
    synchronized public void run() {
        count--;
        System.out.println( this.currentThread().getName() + " , count=" + count);
    }

    public static void main(String[] args) {
        SharedVariableThread sharedVariableThread = new SharedVariableThread();
        Thread a = new Thread(sharedVariableThread, "A");
        Thread b = new Thread(sharedVariableThread, "B");
        Thread c = new Thread(sharedVariableThread, "C");
        Thread d = new Thread(sharedVariableThread, "D");
        Thread e = new Thread(sharedVariableThread, "E");

        a.start();
        b.start();
        c.start();
        d.start();
        e.start();
    }
}