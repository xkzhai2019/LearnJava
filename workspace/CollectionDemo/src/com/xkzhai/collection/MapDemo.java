package com.xkzhai.collection;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
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
		
		// 通过entrySet迭代
		Set<Entry<Integer,String>> entrys = map.entrySet();
		for(Entry<Integer,String> entry:entrys){
			Integer key = entry.getKey();
			String value = entry.getValue();
			System.out.println(key+"-"+value);
		}
		
	    // 通过key迭代
		System.out.println("===========");
	    System.out.println(map.get(100));	    
	    map.remove(100);
	    Set<Integer> keys = map.keySet();
	    for(Integer key: keys){
	    	System.out.println(key+"-"+map.get(key));
	    }
	    
	    // 	通过迭代器
	    System.out.println("===========");
	    Map<String,String> map2 = new HashMap<String,String>();
	    map2.put("key001","tom1");
	    map2.put("key002","tom2");
	    map2.put("key003","tom3");
	    map2.put("key004","tom3");
	    Set<Entry<String,String>> set = map2.entrySet();
	    Iterator<Entry<String,String>> it = set.iterator();
	    while(it.hasNext()){
	    	Entry<String,String> entry = it.next();
	    	String key = entry.getKey();
	    	String value = entry.getValue();
	    	System.out.println(key+"-"+value);
	    }
	    
	    System.out.println("===========");
	    Set<String> keys2= map2.keySet();
	    Iterator<String> it2 = keys2.iterator();
	    while(it2.hasNext()){
	    	String key = it2.next();
	    	String value = map2.get(key);
	    	System.out.println(key+"-"+value);
	    }
	    
	    System.out.println("===========");
	    Collection<String> values = map2.values();  
	    Iterator<String> it3 = values.iterator();
	    while(it3.hasNext()){
	    	System.out.println(it3.next());
	    }
	}
}
