package com.da.sort;

/**
 * @author lryepoch
 * @date 2021/1/20 20:24
 * @description 基数排序
 */
public class RadixSort {
	public void radixSort(int[] A, int n) {
		
		//遍历序列找出最大的数(为的是确定最大的数是几位数)；
		int max = A[0];
		for (int i = 1; i < n; i++) {
			if (max < A[i])
				max = A[i];
		}
		double d = Math.pow(10, String.valueOf(max).length());

		int k = 1;//代表位数对应的数：1,10,100...
		int[][] tong = new int[10][n]; //桶，排序桶用于保存每次排序后的结果，这一位上排序结果相同的数字放在同一个桶里
		int[] num = new int[n]; // 记录每个桶中存入数的个数
		
		//遍历完所有位上的数字
		while (k < d) {
			
			//将数组array里的每个数字放在相应的桶里
			for (int a : A) {	
				int m = (a / k) % 10;
				tong[m][num[m]] = a;
				//System.out.println("num[m]"+num[m]);
				num[m]++;
			}
			
			int c = 0;//保存每一位排序后的结果用于下一位的排序输入
			
			//将前一个循环生成的桶里的数据覆盖到原数组中用于保存这一位的排序结果
			for (int i = 0; i < n; i++) {
				
				//这个桶里有数据，从上到下遍历这个桶并将数据保存到原数组中
				if (num[i] != 0) {
					for (int j = 0; j < num[i]; j++) {
						A[c] = tong[i][j];
						c++;
					}
				}
				num[i] = 0;	//将桶里计数器置0，用于下一次位排序
			}
			k = k * 10;
		}
	}

	public static void main(String[] args) {

		int[] A = { 12, 1, 23, 123, 222, 65, 34 };
		RadixSort r = new RadixSort();

		r.radixSort(A, 7);
		for (int a : A) {
			System.out.print(a + " ");
		}
	}
}
