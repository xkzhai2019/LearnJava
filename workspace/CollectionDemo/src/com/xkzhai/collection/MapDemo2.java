package com.xkzhai.collection;

import java.util.HashMap;
import java.util.Map;

public class MapDemo2 {

	public static void main(String[] args) {
		Map<MyKey, Cat> map = new HashMap<MyKey, Cat>();
		
		map.put(new MyKey("tom-1"), new Cat("tom-1",12));
		MyKey k1 = new MyKey("tom-2");
		map.put(k1, new Cat("tom-2",13));
		
		map.put(new MyKey("tom-3"), new Cat("tom-3",14));
		
		System.out.println(map.size());
		
		Cat c= map.get(new MyKey("tom-1"));
		System.out.println(c);
		
		System.out.println(map.get(k1));
	}

}

class Cat{
	private String name;
	private int height;
	public Cat(String name, int height) {
		super();
		this.name = name;
		this.height = height;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getHeight() {
		return height;
	}
	public void setHeight(int height) {
		this.height = height;
	}
	
}

class MyKey{
	private String name;
	private Integer age;

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public MyKey(String name) {
		super();
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public int hashCode() {
		int namehash = name ==null ? 0: name.hashCode();
		int agehash = age ==null ? 0: age.intValue();
		//System.out.println("hash");
		return namehash + agehash;
	}
	
	@Override
	public boolean equals(Object obj) {
		MyKey key0 = (MyKey)obj;
		return name.equals(key0.name) && age==key0.age;
	}
}
