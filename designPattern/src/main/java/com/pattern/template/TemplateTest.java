package com.pattern.template;

/**
 * 模板模式
 *
* @description 一个抽象类公开定义了执行它的方法的方式/模板。它的子类可以按需要重写方法实现，但调用将以抽象类中定义的方式进行
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
