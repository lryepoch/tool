package thread;

/**
* @description 数据不共享
* @author lryepoch
* @date 2020/7/29 14:01
*
*/
public class ThreadA extends Thread {
    private int count=5;

    public ThreadA(String target) {
        this.setName(target);   //设置线程名称
    }

    @Override
    public void run() {
        while (count>0){
            count--;
            System.out.println("由" + this.currentThread().getName() + "计算,count=" + count);
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
