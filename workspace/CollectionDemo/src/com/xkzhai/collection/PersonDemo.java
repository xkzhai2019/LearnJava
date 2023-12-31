package com.xkzhai.collection;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class PersonDemo {

	public static void main(String[] args) {
		List<Person> list = new ArrayList<Person>();
		Person p = null;
		for(int i=0;i<100;i++){
		    p = new Person();
			p.setName("tom"+i);
			p.setAge(i%100);
			list.add(p);
		}

		Iterator<Person> it = list.iterator();
		while(it.hasNext()){
			Person p1 = it.next();
			System.out.println("Person{"+p1.getName()+","+p1.getAge()+"}");
			//System.out.println(it.next().getName()+"="+it.next().getAge());
		}
		
		System.out.println("list.contains(new Person(\"tom99\",99)) = "+list.contains(new Person("tom99",99)));
		
//		Person p1 = new Person("tom1",1);
//		Person p2 = new Person("tom1",1);
		Person p1 = new Person(null,1);
		Person p2 = new Person("",1);
		System.out.println(p1==p2);
		System.out.println(p1.equals(p2)); // 需要重写equals方法
		
	}

}
