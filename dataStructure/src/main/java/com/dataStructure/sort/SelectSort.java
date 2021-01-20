package com.dataStructure.sort;

/**
 * @author lryepoch
 * @date 2021/1/20 20:24
 * @description 选择排序
 */
public class SelectSort {
	public void selectSort(int a[]){
		for(int i=0;i<a.length-1;i++){
			for(int j=i+1;j<a.length;j++){
				if(a[i]>a[j]){
					int temp=a[i];
					a[i]=a[j];
					a[j]=temp;
				}
			}
		}
	}
	public static void main(String[] args) {
		
		SelectSort selectSort= new SelectSort();
		int[] a={6,4,7,1,4,0};
		for (int i : a) {
			System.out.print(i+" ");
		}
		System.out.println();
		selectSort.selectSort(a);
		for (int j = 0; j < a.length; j++) {
			System.out.print(a[j]+" ");
		}

	}

}
