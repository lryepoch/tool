package com.base.junit4;

import static org.junit.Assert.*;

import org.junit.Test;

//快速上手
public class CalculateTest {

	@Test
	public void testAdd(){
		assertEquals(6, new Calculate().add(3, 3));
	}
	
	@Test
	public void testSubtract(){
		assertEquals(0, new Calculate().subtract(2, 2));
	}
	
	@Test
	public void testMultiply(){
		//断言使用了静态导入
		assertEquals(6, new Calculate().multiply(3, 2));
	}
	
	@Test
	public void testDivide(){
		assertEquals(1, new Calculate().divide(2, 2));
	}

}
