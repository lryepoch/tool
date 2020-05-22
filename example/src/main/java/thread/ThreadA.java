package thread;


public class ThreadA extends Thread {

    @Override
    public void run() {
        System.out.println("ThreadA.run()");
    }

    public static void main(String[] args) {
        ThreadA a = new ThreadA();
        ThreadA b = new ThreadA();
        ThreadA c = new ThreadA();
        ThreadA d = new ThreadA();
        ThreadA e = new ThreadA();
        a.start();
        b.start();
        c.start();
        d.start();
        e.start();
        
    }
}
