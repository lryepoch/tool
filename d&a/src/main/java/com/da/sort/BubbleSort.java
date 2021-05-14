package com.da.sort;

/**
 * 冒泡排序优化
 */
public class BubbleSort {
//	public void bubbleSort(int[] a) {
//		for (int i = 0; i < a.length - 1; i++)
//			for (int j = 0; j < a.length - 1 - i; j++) {
//				if (a[j] > a[j + 1]) { // 大数沉下去
//					int temp = a[j];
//					a[j] = a[j + 1];
//					a[j + 1] = temp;
//				}
//			}
//	}

    public void bubbleSort(int[] a) {
        int low = 0, high = a.length - 1;
        while (low < high) {
            for (int i = low; i < high; i++) {
                if (a[i] > a[i + 1]) {
                    int temp = a[i];
                    a[i] = a[i + 1];
                    a[i + 1] = temp;
                }
            }
            high--;
            for (int j = high; j > low; j--) {
                if (a[j] < a[j - 1]) {
                    int temp = a[j];
                    a[j] = a[j - 1];
                    a[j - 1] = temp;
                }
            }
            low++;
        }
    }

    public static void main(String[] args) {
        int[] a = {1, 6, 3, 8, 0, 1};
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.println();
        BubbleSort bubbleSort = new BubbleSort();
        bubbleSort.bubbleSort(a);
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }

    }

}




