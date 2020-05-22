package thread;

public class ThreadB implements Runnable{

    @Override
    public void run() {
        System.out.println("ThreadB.run()");
    }

    public static void main(String[] args) {

        ThreadB threadB = new ThreadB();
        ThreadB threadB1 = new ThreadB();
        Thread thread = new Thread(threadB);
        Thread thread1 = new Thread(threadB1);

        thread.start();
        thread1.start();
    }
}
