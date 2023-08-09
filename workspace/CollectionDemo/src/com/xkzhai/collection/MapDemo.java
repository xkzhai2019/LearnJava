package com.xkzhai.collection;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class MapDemo {
	public static void main(String[] args) {
		// Key-value对
		// Map接口为单独的接口，没有继承其他
		Map<Integer, String> map = new HashMap<Integer, String>();
		// HashMap.hash()将新hash值与更多的特征值相关
		// 异或：00 01 10 11 
		
		map.put(100, "tom-100");
		map.put(200, "tom-200");
		map.put(300, "tom-300");
		
		// 将key与value关联，如果key已存在，则覆盖原来的值
		map.put(100, "tom-300");
		System.out.println(map.size());
		
		// 迭代
		Set<Entry<Integer,String>> entrys = map.entrySet();
		for(Entry<Integer,String> entry:entrys){
			Integer key = entry.getKey();
			String value = entry.getValue();
			System.out.println(key+"-"+value);
		}
		
	    System.out.println(map.get(100));
	    
	    map.remove(100);
	    // 通过key迭代
	    Set<Integer> keys = map.keySet();
	    for(Integer key: keys){
	    	System.out.println(key+"-"+map.get(key));
	    }
	    
	    
	    
	}
}
