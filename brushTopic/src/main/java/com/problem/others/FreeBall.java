package com.problem.others;

/**
 * 一球从100米高度自由落下，每次落地后反跳回原高度的一半；再落下，求它在第10次落地时，共经过多少米？第10次反弹多高？
 */
public class FreeBall {
    public static void main(String[] args) {
        double h = 100;
        double s = 0;
        for (int i = 1; i <= 10; i++) {
            s = s + h;
            h = h / 2;
            if (i != 1) s = s + 2 * h;

        }
        System.out.println("第十次落地时经过的路程为" + s);
        System.out.println("第十次反弹高度为" + h);
    }

}
