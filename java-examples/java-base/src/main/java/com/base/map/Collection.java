package com.base.map;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

//ArrayList
public class Collection {
	public static void main(String[] args) {

		List<String> list = new ArrayList<>();
		System.out.println(list==null);
		System.out.println(list.size());
		list.add("haha");
		list.add("zenggou");

		// foreach
		for (String str : list) {
			System.out.println(str);
		}

		// for循环
		for (int i = 0; i < list.size() - 1; i++) {
			System.out.println(list);
		}
		//or
		System.out.println(list);
		
		// 使用迭代器iterator
		Iterator<String> ite = list.iterator();
		while (ite.hasNext()) {
			System.out.println(ite.next());
		}

		System.out.println("--------------------");
		// 字符串数组，把集合转成数组，再遍历
		String[] array = new String[(list.size())];
		list.toArray(array);
		
		// foreach
		for (String str : array) {
			System.out.println(str);
		}
		// for循环
		for (int i = 0; i < array.length; i++) {
			System.out.println(array[i]);
		}

	}
}

 //HashSet
//public class Collection {
//	 public static void main(String[] args) {
//		 Set set = new HashSet();
//		 set.add("zenggou");
//		 set.add("goubi");
//		 set.add("zenggou");
//		 set.add("google");
//		 System.out.println(set.size());
//		 System.out.println(set.toString());
//
//	 }
//}
