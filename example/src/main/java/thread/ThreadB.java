package thread;

/**
* @description ���ݹ������ܳ����̰߳�ȫ����
* @author lryepoch
* @date 2020/7/29 13:49
*
*/
public class ThreadB extends Thread {

    private int count = 5;

    @Override
    synchronized public void run() {
        count--;
        System.out.println("��" + this.currentThread().getName() + "����,count=" + count);
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
