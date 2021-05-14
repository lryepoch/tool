package com.da.stack;

import java.util.Stack;

public class StackTest {
	public static void main(String[] args) {
		Stack stack=new Stack();
		System.out.println(stack.empty());
		stack.push(1);
		stack.push('a');
		stack.add(4);
		System.out.println(stack);
		Object a = 'a';
		System.out.println(stack.search(a));
		System.out.println(stack.peek());
		stack.pop();
		System.out.println(stack.peek());
		stack.clear();
		System.out.println(stack);
	}

}
