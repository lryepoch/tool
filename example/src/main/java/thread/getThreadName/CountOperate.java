package thread.getThreadName;

/**
* 获取线程名
*/
public class CountOperate extends Thread {

    public CountOperate() {
        System.out.println("-----begin-----");
        System.out.println(Thread.currentThread().getName());
        System.out.println(this.getName());
        System.out.println("------end------");
    }

    @Override
    public void run() {
        System.out.println("=======run======");
        System.out.println(Thread.currentThread().getName());
        System.out.println(this.getName());
        System.out.println("=======end=======");
    }

}
