package com.dataStructure.sort;

/**
 * @author lryepoch
 * @date 2021/1/20 20:23
 * @description 堆排序
 */
public class HeapSort {
	public void heapAdjust(int[] a,int s,int length){
		int temp=a[s];
		int child=2*s+1;
		while(child<length){
			if(child+1<length && a[child] < a[child+1]){
				child++;
			}
			if(a[child]>a[s]){
				a[s]=a[child];
				s=child;
				child=2*s+1;
			}else{
				break;
			}
			a[s]=temp;
		}
	}
	public void buildHeap(int[] a,int length){
		int c=(length-1)/2;
		for(int i=c;i>=0;i--){
			heapAdjust(a,i,length);
		}
	}
	public void heapSort(int[] a ,int length){
		buildHeap(a,length);
		for (int i =length-1; i >0 ; i--) 
		{	
			int temp=a[i];
			a[i]=a[0];
			a[0]=temp;
			heapAdjust(a,0,i);
		}
	}
	public static void main(String[] args) {
		int[] a={9,1,6,3,8,1,6};
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i]+" ");
		}
		System.out.println();
		HeapSort heapSort=new HeapSort();
		heapSort.heapSort(a,7);
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i]+" ");
		}

	}

}
