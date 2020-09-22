package com.dataInstructure.sort;

public class ShellSort {
	public void shellSort(int[] a){
		int dk=a.length/2;
		while (dk>=1) {
			for(int i=dk;i<a.length;i++){
				if(a[i]<a[i-dk]){
					int x=a[i];
					int j;
					for(j=i-dk;j>=0 && a[j]>x; j--)
						a[j+dk]=a[j];
					a[j+dk]=x;
					}
				}
			dk=dk/2;
			}
	}
	public static void main(String[] args) {
		ShellSort shell = new ShellSort();
		int[] a={2,4,1,9,6,9};
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i]+" ");
		}
		shell.shellSort(a);
		System.out.println();
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i]+" ");
		}

	}

}
