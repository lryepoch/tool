package com.problem.others;

import java.util.Scanner;

/**
* 统计输入的字符串出现的各种符号并返回
*/
public class JudgeType {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String string = sc.nextLine();
        int a = 0;
        int b = 0;
        int c = 0;
        int d = 0;
        int k;
        for (int i = 0; i < string.length(); i++) {
            k = string.charAt(i);
            //如果是空字符
            if (k == ' ')
                a++;
            //如果是数字
            else if (Character.isDigit(k))
                b++;
            //如果是字母
            else if (k >= 'A' && k <= 'Z' || k >= 'a' && k <= 'z')
                c++;
            //其他
            else d++;
        }

        System.out.println("字母：" + c);
        System.out.println("空字符：" + a);
        System.out.println("数字:" + b);
        System.out.println("other：" + d);

    }

}
