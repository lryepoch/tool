package com.base.thread.getThreadName;

public class CountOperateExample {
    public static void main(String[] args) {

        CountOperate countOperate = new CountOperate();
        Thread t1 = new Thread(countOperate);
		t1.setName("A");
        t1.start();

    }

}
