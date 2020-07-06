package others;

import java.util.Scanner;

public class Judge {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String string = sc.nextLine();
		int a=0;
		int b=0;
		int c=0;
		int d=0;
		int k=0;
		for(int i=0;i<string.length();i++){
			k=string.charAt(i);
			if(k==' ')
				a++;
			else if (Character.isDigit(k)) 
				b++;
			else if(k>='A' && k<='Z'|| k>='a' && k<='z')
				c++;
			else d++;
		}
		
		System.out.println("Ӣ����ĸ������"+c);
		System.out.println("�ո������"+a);
		System.out.println("���ָ���:"+b);
		System.out.println("�����ַ�������"+d);

	}

}
