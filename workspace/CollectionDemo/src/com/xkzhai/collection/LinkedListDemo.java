package com.xkzhai.collection;

import java.util.LinkedList;
import java.util.List;

public class LinkedListDemo {

	public static void main(String[] args) {
		// 链表
		// 通过手拉手实现对象引用
		// 存储速度快，查询慢
		List<String> list = new LinkedList<String>();
		list.add("tom");
		list.add(0,"alice");
		list.add("bob");
		
		for(int i=0;i<list.size();i++){
			System.out.println(list.get(i));
		}
		
	}

}
