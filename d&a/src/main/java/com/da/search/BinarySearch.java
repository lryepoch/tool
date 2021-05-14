package com.da.search;

/**
 * @author lryepoch
 * @date 2021/5/14 14:10
 * @description TODO 二分查找
 * <p>
 * 前提条件：需要有序表顺序存储;
 * 适用于不经常变动而查找频繁的有序列表；
 *
 * 空间复杂度O(1)
 */

/**
 * 总共有n个元素，渐渐跟下去就是n,n/2,n/4,....n/2^k（接下来操作元素的剩余个数），其中k就是循环的次数
 * 由于你n/2^k取整后>=1，即令n/2^k=1
 * 所以，时间复杂度O(logn)
 */
public class BinarySearch {

    /**
     * 递归实现
     * <p>
     * 使用递归时，方法参数需要携带诸如 left，right；start，end；low，high；
     */
    public int search_Bin(int[] a, int left, int right, int target) {
        int mid = (left + right) / 2;
        int midValue = a[mid];
        if (left <= right) {            //用if不用while
            if (midValue > target) {
                return search_Bin(a, left, mid - 1, target);
            } else if (midValue < target) {
                return search_Bin(a, mid + 1, right, target);
            } else {
                return mid;
            }
        }
        return -1;
    }

    /**
     * 非递归实现
     */
    public int search_Bin(int[] a, int key) {
        int low = 0;
        int high = a.length - 1;
        while (low <= high) {        //用while不用if
            int mid = (low + high) / 2;
            if (a[mid] > key)
                high = mid - 1;
            else if (a[mid] < key) {
                low = mid + 1;
            } else return mid;
        }
        return -1;
    }
}
