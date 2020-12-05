package thread.getThreadName;

public class RunExample {
    public static void main(String[] args) {

        CountOperate c = new CountOperate();
        Thread t1 = new Thread(c);
//		t1.setName("A");
        t1.start();

    }

}
