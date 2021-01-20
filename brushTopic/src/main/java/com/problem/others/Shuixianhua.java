package com.problem.others;

/**
 * 打印出所有的 水仙花数 ，所谓 水仙花数 是指一个三位数，其各位数字立方和等于该数本身。例如：153是一个 水仙花数 ，因为153=1的三次方＋5的三次方＋3的三次方。
 * 1.程序分析：利用for循环控制100-999个数，每个数分解出个位，十位，百位。
 */
public class Shuixianhua {
    public static void main(String[] args) {
        ShuiXianHua s = new ShuiXianHua();
        for (int i = 100; i <= 999; i++)

            if (s.find(i) == true)
                System.out.println("水仙花数如下" + i);
    }
}

class ShuiXianHua {
    public boolean find(int x) {
        int i = x / 100;                        //确定百位数
        int j = (x % 100) / 10;              //确定十位数
        int k = x % 10;                       //确定个位数
        if (x == i * i * i + j * j * j + k * k * k)
            return true;
        else return false;
    }

}
