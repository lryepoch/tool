package com.da.sort;

/**
 * @author lryepoch
 * @date 2021/1/20 20:24
 * @description 归并排序
 */
public class MergeSort {
	public void merge(int[] a, int start, int mid, int end) {
		//借助一个过渡数组
		int[] b = new int[a.length];
		
		int i = start;		//a
		int j = mid + 1;	//a
		int k = start;		//b
		
		System.out.println("merge:"+start+"~"+end);
		while (i <= mid && j <= end) {		//将a中记录由小到大并入b中。
			if (a[i] < a[j])
				b[k++] = a[i++];		
			else
				b[k++] = a[j++];		
		}
		while (i <= mid)
			b[k++] = a[i++];		//将剩余的a[start…mid]复制到b中
		while (j <= end)
			b[k++] = a[j++];		//将剩余的a[mid+1…end]复制到b中

		for (int n = start; n <= end; n++) {	 //排好序的b归还给a
			a[n] = b[n];
		}
		for (int m : a) {
			System.out.print(m+" ");
		}
		System.out.println();
		System.out.println("--------------------------------");
	}

	//内部使用递归
	public void mergeSort(int[] a, int start, int end) {
		if (start < end) {
			int mid = (start + end) / 2;		         //将当前序列一分为二，求出分裂点mid
			mergeSort(a, start, mid);		// 左边有序	 //递归归并排序……a[low…mid]
			mergeSort(a, mid + 1, end);		// 右边有序	 //递归归并排序……a[mid+1…high]
			
			 //不断在原来的基础上，将a[start...mid]和a[mid+1...end]归并到b[start...end]
			merge(a, start, mid, end);			//最后整合在一起
		}
	}

	public static void main(String[] args) {
		MergeSort mergeSort = new MergeSort();
		int[] a = { 9, 5, 8, 1, 0, 5, 7 };

		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i] + " ");
		}
		System.out.println();
		mergeSort.mergeSort(a, 0, a.length - 1);
	}
}
