package com.base.junit4;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;


//JUnit4的运行流程
public class JunitFlowTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		System.out.println("this is beforeclass");
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		System.out.println("this is afterclass");
	}

	@Before
	public void setUp() throws Exception {
		System.out.println("this is before");
	}

	@After
	public void tearDown() throws Exception {
		System.out.println("this is after");
	}

	@Test
	public void test() {
		System.out.println("this is test.........");
	}

}
