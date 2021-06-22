package com.base.junit4;

import static org.junit.Assert.*;

import org.junit.Ignore;
import org.junit.Test;

//常用注解的使用
public class AnnotationTest {

	@Test(expected=ArithmeticException.class)
	public void testDivide(){
		assertEquals(1, new Calculate().divide(2, 0));
	}
	
	@Ignore("忽略了")
	@Test(timeout=2000)
	public void testWhile(){
		while(true){
			System.out.println("run forever……");
		}
	}
	
	@Test(timeout=4000)
	public void testReadFile(){
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
