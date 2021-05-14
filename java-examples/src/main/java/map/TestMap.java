package map;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

//hashmap
public class TestMap {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Map<String, Integer> map = new HashMap<>();
		map.put("大学物理", 99);
		map.put("大学英语", 100);
		map.put("高等数学", 99);
		System.out.println(map.get("大学物理"));
		System.out.println(map.put("大学物理", 100));
		System.out.println(map);
		
		System.out.println(map.containsKey("大学英语"));
		System.out.println(map.containsValue(100));
		map.remove("大学物理");
		
		System.out.println("1-----------------");
		//1增强for循环
		for (Object key : map.keySet()) {
			System.out.println(map.get(key));
		}
		
		System.out.println("2-----------------");
		//2迭代器
		//效率高,以后一定要使用此种方式！
		Iterator ite=map.entrySet().iterator();
		while(ite.hasNext()){
			Map.Entry entry=(Map.Entry)ite.next();
			Object key=entry.getKey();
			System.out.println(key);
			Object value=entry.getValue();
			System.out.println(value);
		}
		
		System.out.println("3-------------------");
		//效率低,以后尽量少使用！
		Iterator<String> ite2=map.keySet().iterator();
		while(ite2.hasNext()){
			Object key = ite2.next();
			System.out.println(key);
			Object value=map.get(key);
			System.out.println(value);
		}
		
	}

}
