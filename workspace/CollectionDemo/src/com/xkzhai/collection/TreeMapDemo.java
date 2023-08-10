package com.xkzhai.collection;

import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;

public class TreeMapDemo {

	public static void main(String[] args) {
		TreeMap<String, Student> tm1 = new TreeMap<String, Student>();
		tm1.put("tom1", new Student(1,2,3));
		tm1.put("tom2", new Student(1,2,3));
		tm1.put("tom3", new Student(1,2,3));
		tm1.put("tom4", new Student(1,2,3));
		
		System.out.println(tm1.size());
		
		TreeMap<Student, String> tm2 = new TreeMap<Student, String>();
		tm2.put(new Student(1,3,4),"tom1");
		tm2.put(new Student(1,4,3),"tom2");
		tm2.put(new Student(1,2,3),"tom3");
		System.out.println(tm2.size());
		
		for(Entry<Student,String> entry : tm2.entrySet()){
			Student key = entry.getKey();
			String value = entry.getValue();
			System.out.println(key+":"+value);
		}
		
		//TreeMap<PersonForTS, String> tm3 = new TreeMap<PersonForTS, String>();
		TreeMap<PersonForTS, String> tm3 = new TreeMap<PersonForTS, String>(new PersonForTSComparator());
		tm3.put(new PersonForTS(100),"tom1");
		tm3.put(new PersonForTS(100),"tom2");
		tm3.put(new PersonForTS(200),"tom3");
		tm3.put(new PersonForTS(300),"tom4");
		System.out.println(tm3.size());
		// 得到所有key
		Set<PersonForTS> keys = tm3.keySet();
		Iterator<PersonForTS> it=keys.iterator();
		for(;it.hasNext();){
			PersonForTS p = it.next();
			String value = tm3.get(p);
			System.out.println(p.getHeight()+"-"+value);
		}
	}

}
