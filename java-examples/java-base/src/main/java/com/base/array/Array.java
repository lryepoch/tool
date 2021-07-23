package com.base.array;

import java.util.Arrays;
import java.util.List;

/**
 * @author lryepoch
 * @date 2019-12-17 2019/12/17
 * @description 数组与集合之间的转换
 */
public class Array {
    public static void main(String[] args) {
        Integer[] ids = new Integer[]{3,5,5,4};
        List<Integer> list = Arrays.asList(ids);
        System.out.println(list.getClass());
        System.out.println(list);
        System.out.println(Arrays.asList(ids));
    }
}

