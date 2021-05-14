package com.da.queue;

import java.util.LinkedList;
import java.util.Queue;

public class QueueTest {

	public static void main(String[] args) {
		Queue<String> queue = new LinkedList<String>();
		queue.offer("12");
		queue.offer("ig");
		queue.offer("rng");
		queue.offer("barcelona");
		System.out.println(queue);
		System.out.println(queue.peek());
		
		queue.poll();
		for (String string : queue) {
			System.out.print(string+" ");
		}
		System.out.println();
		System.out.println(queue.element());
	}

}
