package com.dataInstructure.sort;

public class InsertSort {
	public void insertSort(int[] A) {
		for (int i = 1; i < A.length; i++) {
			if (A[i] < A[i - 1]) {
				int x = A[i];
				int j;
				for (j = i - 1; j>=0 && A[j] > x; j--)
					A[j + 1] = A[j];
				A[j + 1] = x;
			}
		}
	}

	public static void main(String[] args) {
		InsertSort insert = new InsertSort();
		int[] A = { 2, 5, 3, 8, 0, 5 };

		for (int j = 0; j < A.length; j++) {
			System.out.print(A[j] + " ");
		}

		System.out.println();
		insert.insertSort(A);

		for (int i = 0; i < A.length; i++) {
			System.out.print(A[i] + " ");

		}
	}
}
