package sort;

import java.util.Scanner;

//冒泡排序
public class Bubble {
	public void bubbleSort(int[] a) {
		for (int i = 0; i < a.length - 1; i++)
			for (int j = 0; j < a.length - 1 - i; j++) {
				if (a[j] > a[j + 1]) { // 大数沉下去
					int temp = a[j];
					a[j] = a[j + 1];
					a[j + 1] = temp;
				}
			}
	}
	
	public static void main(String[] args) {
		
		Bubble bubble = new Bubble();
		Scanner scanner= new Scanner(System.in);
		
		System.out.println("请输入待排序数字的个数：");
		int b = scanner.nextInt();
		
		int[] a = new int[b];
		
		System.out.println("请输入待排序的数字：");
		for (int i = 0; i < a.length; i++) {
			a[i] = scanner.nextInt();	
		}
		
		System.out.println();
		
		System.out.println("数字排序后的结果如下：");
		bubble.bubbleSort(a);
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i] + " ");
		}
		

	}

}


