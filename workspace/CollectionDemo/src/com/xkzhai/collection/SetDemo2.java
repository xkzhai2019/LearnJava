package com.xkzhai.collection;

import java.util.HashSet;
import java.util.Set;

public class SetDemo2 {

	public static void main(String[] args) {
		Set<Dog> dogs = new HashSet<Dog>();
//		dogs.add(new Dog("white"));
//		dogs.add(new Dog("white"));
		Dog d1 = new Dog("white");
		Dog d2 = new Dog("white");
		System.out.println(d1.hashCode());
		System.out.println(d1.hashCode());
	
		dogs.add(d1);
		dogs.add(d1);
		System.out.println(dogs.size());
		
		System.out.println(dogs.contains(new Dog("black")));
	}

}

class Dog{
	private static int no = 0;
	private String name;
	
	public Dog(String name) {
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
		return no++;
	}
	
	@Override
	public boolean equals(Object obj) {
		return true;
	}
}
