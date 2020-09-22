package thread;

/**
* @description ���ݲ�����
* @author lryepoch
* @date 2020/7/29 14:01
*
*/
public class ThreadA extends Thread {
    private int count=5;

    public ThreadA(String target) {
        this.setName(target);   //�����߳�����
    }

    @Override
    public void run() {
        while (count>0){
            count--;
            System.out.println("��" + this.currentThread().getName() + "����,count=" + count);
        }
    }

    public static void main(String[] args) {
        ThreadA a = new ThreadA("A");
        ThreadA b = new ThreadA("B");
        ThreadA c = new ThreadA("C");
        ThreadA d = new ThreadA("D");
        ThreadA e = new ThreadA("E");
        a.start();
        b.start();
        c.start();
        d.start();
        e.start();
    }

}
