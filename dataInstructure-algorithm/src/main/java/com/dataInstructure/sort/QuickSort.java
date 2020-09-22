package com.dataInstructure.sort;

public class QuickSort {
	public int partition(int[] a,int low,int high) {
		int pivotkey = a[low];
		
		while (low < high) {
			while (low<high && a[high] >= pivotkey)
				high--;
			a[low] = a[high];
			while (low<high && a[low] <= pivotkey)
				low++;
			a[high] = a[low];
		}
		a[low] = pivotkey;
		return low;
	}

	public void quickSort(int[] a, int low, int high) {
		if(low < high) {
			int pivotloc = partition(a,low,high);
			quickSort(a, low, pivotloc - 1);
			quickSort(a, pivotloc + 1, high);
		}
	}

	public static void main(String[] args) {
		QuickSort quickSort=new QuickSort();
		int[] a={3,1,3,7,9,5,2};
		for (int i : a) {
			System.out.print(i+" ");
		}
		System.out.println();
		
		quickSort.quickSort(a, 0, 6);
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i]+" ");
		}

	}

}
