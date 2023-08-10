package com.xkzhai.collection;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ProForDemoo {

	public static void main(String[] args) {
		// 1. 数组增强for循环
		int[] arr = {1,2,3,4};
		for(int i: arr){
			System.out.println(i);
		}
		
		// 2. 集合：List Set Map.entrySet| Map.keySet
		List<String> list = new ArrayList<String>();
		list.add("tom");
		list.add("tom");
		list.add("tom");
		list.add("tom");
		for(String s: list){
			System.out.println(s);
		}
		
//		Iterator<String> it = list.iterator();
//		for(String ss: it){
//			
//		}
		
		// 3. 变长参数
		PersonForTS p = new PersonForTS(100);
		p.addTel("12349q343");
		p.addTel("12349q344");
		p.addTel("1","12","123","12345");
		p.addTel();
	}

}
