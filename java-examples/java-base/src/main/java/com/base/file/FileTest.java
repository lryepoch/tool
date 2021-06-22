package com.base.file;

import java.io.File;
import java.util.ArrayList;
import java.util.LinkedList;

/**
 * @create by 260408 on 2019-09-19 14:22
 * @description 递归文件夹
 */
public class FileTest {
    //深度优先(递归)遍历
    public static void test(File file){
        //System.out.println(com.base.file);
        File[] list = file.listFiles();
        for (File file2 : list) {
            if (file2.isDirectory()) {
                System.out.println(file2);
                test(file2);
            } else {
                System.out.println(file2);
            }
        }
    }

    //深度优先(非递归)遍历
    public static void test2(File file) {
        LinkedList<File> list = new LinkedList<>();
        list.push(file);
        //list集合
        while (!list.isEmpty()) {
            File f1 = list.pop();
            //System.out.println(f1);
            if (f1.isDirectory()) {
                File[] files = f1.listFiles();
                for (File f2 : files) {
                    list.push(f2);
                }
            }
        }
    }

    //广度优先遍历
    public static void test3(File files) {
        ArrayList<File> list = new ArrayList<>();
        list.add(files);
        //先全部add到集合，再集中输出
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).isDirectory()) {
                File[] files1 = list.get(i).listFiles();
                for (File files2 : files1) {
                    list.add(files2);
                }
            }
        }
        for (File f : list) {
            System.out.println(f);
        }
    }

    public static void main(String[] args) {
        File file = new File("C:\\Users\\260408\\Desktop\\我的文件夹");
        test3(file);
    }

}