package com.pattern.behavioral.template;

/**
 * ģ��ģʽ
 *
* @description һ�������๫��������ִ�����ķ����ķ�ʽ/ģ�塣����������԰���Ҫ��д����ʵ�֣������ý��Գ������ж���ķ�ʽ����
* @author lryepoch
* @date 2020/7/7 9:58
*
*/
public class TemplateTest {
	public static void main(String[] args) {
		Game game=new Cricket();
		game.play();
		
		System.out.println();
		
		game=new Football();
		game.play();
	}

}
