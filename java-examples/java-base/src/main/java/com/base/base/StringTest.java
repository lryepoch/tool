package com.base.base;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author lryepoch
 * @date 2021/2/22 11:14
 * @description TODO String类的方法
 */
public class StringTest {
    public static void main(String[] args) {
        String test = "  Bob Loves Alice   ";
        test = test.trim();
        String[] split = test.split("\\s+");
        System.out.println(split.length);
        for(String str:split){
            System.out.println(str);
        }

        List<String> list = Arrays.asList(split);
        Collections.reverse(list);
        String ans = String.join(",", list);
        System.out.println(ans);
    }
}
