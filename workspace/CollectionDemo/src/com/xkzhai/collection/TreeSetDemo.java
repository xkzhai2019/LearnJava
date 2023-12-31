package com.xkzhai.collection;

import java.util.Iterator;
import java.util.TreeSet;

public class TreeSetDemo {

	public static void main(String[] args) {
		TreeSet<String> ts= new TreeSet<String>();
		ts.add("tom1");
		ts.add("tom2");
		ts.add("tom3");
		ts.add("tom");
		ts.add("tom4");
		ts.add("tom2");

		for(String s: ts){
			System.out.println(s);
		}
		
		System.out.println("================");
		//得到迭代器
		Iterator<String> it = ts.iterator();
		while(it.hasNext()){
			String tmp = it.next();
			System.out.println(tmp);
		}
		
		// 字符比较大小
		System.out.println('a'>'b');
		//System.out.println("abc">"bc");
		System.out.println("abc".compareTo("abcd"));
		
		// 实现Comparable接口
		TreeSet<Student> ts2= new TreeSet<Student>();
		ts2.add(new Student(10,11,12));
		ts2.add(new Student(11,12,13));
		ts2.add(new Student(12,13,14));
		ts2.add(new Student(12,14,15));// 与上述对象内容相同，TreeMap判定对象相同取决于compareTo方法的实现
		
		System.out.println(ts2.size());
		for(Student s: ts2){
			System.out.println(s);
		}
		
		// 传入comparator参数	
		System.out.println("---------------");
		TreeSet<PersonForTS> ts3= new TreeSet<PersonForTS>(new PersonForTSComparator());
		ts3.add(new PersonForTS(1));
		ts3.add(new PersonForTS(2));
		ts3.add(new PersonForTS(1));
		ts3.add(new PersonForTS(3));
		
		System.out.println(ts3.size());
		
	}

}
