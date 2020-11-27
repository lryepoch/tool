package thread;

/**
 * @author lryepoch
 * @description 数据不共享
 * @date 2020/7/29 14:01
 */
public class NsharedVariableThread extends Thread {

    private int count = 5;

    public NsharedVariableThread(String target) {
        this.setName(target);   //设置线程名称
    }

    @Override
    public void run() {
        while (count > 0) {
            count--;
            System.out.println("由" + this.currentThread().getName() + "计算,count=" + count);
        }
    }

    public static void main(String[] args) {
        NsharedVariableThread a = new NsharedVariableThread("A");
        NsharedVariableThread b = new NsharedVariableThread("B");
        NsharedVariableThread c = new NsharedVariableThread("C");
        NsharedVariableThread d = new NsharedVariableThread("D");
        NsharedVariableThread e = new NsharedVariableThread("E");
        a.start();
        b.start();
        c.start();
        d.start();
        e.start();
    }
}
