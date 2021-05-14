package thread;

/**
 * @author lryepoch
 * @description 数据不共享，线程安全
 * @date 2020/7/29 14:01
 */
public class NoSharedVariableThread extends Thread {

    private int count = 5;

    public NoSharedVariableThread(String target) {
        this.setName(target);   //设置线程名称
    }

    @Override
    public void run() {
        while (count > 0) {
            count--;
            System.out.println(this.currentThread().getName() + " , count=" + count);
        }
    }

    public static void main(String[] args) {
        NoSharedVariableThread a = new NoSharedVariableThread("A");
        NoSharedVariableThread b = new NoSharedVariableThread("B");
        NoSharedVariableThread c = new NoSharedVariableThread("C");
        NoSharedVariableThread d = new NoSharedVariableThread("D");
        NoSharedVariableThread e = new NoSharedVariableThread("E");
        a.start();
        b.start();
        c.start();
        d.start();
        e.start();
    }
}
