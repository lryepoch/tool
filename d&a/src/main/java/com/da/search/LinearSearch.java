package com.da.search;

/**
 * @author lryepoch
 * @date 2021/5/14 14:09
 * @description TODO 顺序查找
 *
 * 时间复杂度O(n)，遍历数组
 * 空间复杂度O(1)
 */
public class LinearSearch {
    public int seqSearch(int[] a,int key){
        for (int i=0; i<a.length; i++){
            if (a[i]==key)
                return i;
        }
        return -1;
    }
}
