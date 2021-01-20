package com.problem.tooffer;

/**
 * 要求：
 * 实现一个函数来调整该数组中数字的顺序，使得所有的奇数位于数组的前半部分，所有的偶数位于数组的后半部分，并保证奇数和奇数，偶数和偶数之间的相对位置不变。
 */
public class ReOrderArray {
    public void reOrderArray(int[] array) {
        StringBuffer s = new StringBuffer();
        StringBuffer s2 = new StringBuffer();

        for (int i = 0; i < array.length; i++) {
            if (array[i] % 2 == 1) {
                s.append(array[i]);
            } else {
                s2.append(array[i]);
            }
        }
        System.out.print(s);
        System.out.println();
        System.out.print(s2);
        System.out.println();
        s.append(s2);
        System.out.println(s);
        String s3 = s.toString();
        System.out.println("string型：" + s3);

        char[] s4 = s3.toCharArray();
        for (int j = 0; j < s4.length; j++) {
            System.out.print(s4[j] + " ");

        }
        System.out.println();
        for (int j = 0; j < s4.length; j++) {
            array[j] = Integer.parseInt(String.valueOf(s4[j]));
            System.out.print(array[j] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5, 6, 7};
        ReOrderArray o = new ReOrderArray();
        o.reOrderArray(array);
        for (int i : array) {
            System.out.print(i + " ");
        }
    }
}