package com.problem.others;

import java.util.List;
import java.util.ArrayList;

/**
 * 乱序输出3次0-9这10个不重复的数字，并且这3次结果都不一样
 */
public class Luanxu {

    public static void main(String[] args) {
        for (int j = 0; j < 3; j++) {
            List<Integer> list = new ArrayList<>();

            while (list.size() < 10) {
                Integer a = (int) (Math.random() * 10);
                System.out.print(a + " ");
                if (!list.contains(a)) {
                    list.add(a);
                }
            }
            System.out.println("-------------");
            for (int i : list)
                System.out.print(i);

        }
    }

}
