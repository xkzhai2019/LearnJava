package com.xkzhai.collection;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class SetDemo {

	public static void main(String[] args) {
		// hash��ɢ�У�ȥ�أ����� 
		Set<String> set = new HashSet<String>();
		set.add("tom");
		set.add("tom");
		set.add("tommas");
		set.add("tommas");
		set.add("tommasLee");
		System.out.println(set.size());
		
		set.add("alice");
		Iterator<String> it = set.iterator();
		while(it.hasNext()){
			System.out.println(it.next());
		}
	}

}
