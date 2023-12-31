package com.xkzhai.collection;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ListDemo {
	public static void main(String[] args) {
		// 定义集合List
		List<String> list = new ArrayList<String>();
		// 增加元素：牵一发而动全省
		list.add("tom");
		list.add("tom");
		list.add("xkzhai");
		list.add("Lee");
		list.add(0, "Alice");
		list.add(2, "Bob");
		
		// 遍历：查询很快
		System.out.println(list.size());
		for(int i=0;i<list.size();i++){
			System.out.println(list.get(i));			
		}
		
		System.out.println("list.indexOf(\"tom\")："+list.indexOf("tom"));
		System.out.println("list.contains(\"Alice\")："+list.contains("Alice"));
		System.out.println("list.lastIndexOf(\"tom\")："+list.lastIndexOf("tom"));
		
		System.out.println("----------");
		// 通过迭代器来遍历集合
		Iterator<String> it = list.iterator();
		while(it.hasNext()){
			String s = it.next();
			System.out.println(s);
		}
		
		System.out.println("----------");
		// 删除/清空
		list.remove(list.size()-1);
		System.out.println(list.size());
		list.clear();
		System.out.println(list.size());
		
		List<String> list2 = null;
		System.out.println(list2);	
		if(list2!=null && list2.isEmpty()){
			System.out.println(list2.size());
		}
		List<String> list3 = new ArrayList<String>();
		System.out.println(list3.size());
		
//		System.out.println((int)'"');
	}
}
