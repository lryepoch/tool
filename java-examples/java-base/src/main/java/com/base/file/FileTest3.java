package com.base.file;

import java.io.File;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @create by 260408 on 2019-09-23 9:18
 * @description 多线程递归文件夹
 */
public class FileTest3 {

    //线程池遍历
    public static BlockingQueue blockingQueue = new LinkedBlockingQueue(100);

    public static ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(100, 100, 10, TimeUnit.SECONDS, blockingQueue);

    public static void travelFolder(File file) {
        File[] files = file.listFiles();

        for (File f1 : files) {
            if (f1.isDirectory()) {
                threadPoolExecutor.execute(new Runnable() {
                    @Override
                    public void run() {
                        travelFolder(f1);
                    }
                });
            } else {
                String str = f1.toString();
                String[] strings = str.split("\\\\");
                int i = strings.length;
                System.out.println(strings[i-1] + "  " + "/" +strings[i-2]);

            }
        }
    }

    //多线程遍历
    public static void listFile(File file) {
        File[] files = file.listFiles();
        for (File f1 : files) {
            if (f1.isDirectory()){
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        listFile(f1);
                    }
                }).start();
            } else {
                String str = f1.toString();
                String[] strings = str.split("\\\\");
                int i = strings.length;
                System.out.println(strings[i-1] + "  " + "/" +strings[i-2]);
            }
        }
    }


/*    public static void multiFile(File com.base.file) {
        LinkedList<File> list.list = new LinkedList<>();
        list.list.push(com.base.file);

        while (!list.list.isEmpty()) {

            File f1 = list.list.pop();

            if (f1.isDirectory()){
                new Thread(new Runnable() {
                    @Override
                    public void run() {

                        File[] files = f1.listFiles();
                        for (File f2 : files) {
                            list.list.push(f2);
                        }
                    }

                }).start();

            } else {

                String str = f1.toString();
                String[] strings = str.split("\\\\");
                int i = strings.length;

                System.out.println("/" + strings[i - 2] + "/" + strings[i - 1]);

            }
        }
    }*/

    public static void main(String[] args) {

        File file = new File("C:\\Users\\260408\\Desktop\\我的文件夹");

//        travelFolder(com.base.file);
        listFile(file);
//        multiFile(com.base.file);
    }
}