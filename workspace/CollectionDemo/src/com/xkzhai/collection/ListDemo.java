package com.xkzhai.collection;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ListDemo {
	public static void main(String[] args) {
		// ���弯��List
		List<String> list = new ArrayList<String>();
		// ����Ԫ�أ�ǣһ������ȫʡ
		list.add("tom");
		list.add("tom");
		list.add("xkzhai");
		list.add("Lee");
		list.add(0, "Alice");
		list.add(2, "Bob");
		
		// ��������ѯ�ܿ�
		System.out.println(list.size());
		for(int i=0;i<list.size();i++){
			System.out.println(list.get(i));			
		}
		
		System.out.println("list.indexOf(\"tom\")��"+list.indexOf("tom"));
		System.out.println("list.contains(\"Alice\")��"+list.contains("Alice"));
		System.out.println("list.lastIndexOf(\"tom\")��"+list.lastIndexOf("tom"));
		
		System.out.println("----------");
		// ͨ������������������
		Iterator<String> it = list.iterator();
		while(it.hasNext()){
			String s = it.next();
			System.out.println(s);
		}
		
		System.out.println("----------");
		// ɾ��/���
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