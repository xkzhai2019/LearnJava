package com.xkzhai.collection;

import java.util.ArrayList;
import java.util.List;

public class ListContainsDemo {

	public static void main(String[] args) {
	
		List<Car> cars = new ArrayList<Car>();
		for(int i=0;i<10;i++){
			cars.add(new Car("Benz-"+i));
		}
		
		for(Car c: cars){
			System.out.println(c);
		}
		
		Car c = new Car("Benz-0");
		System.out.println(cars.contains(c)); // 需重写equals方法
		System.out.println(null==null);
		System.out.println(cars.contains(cars.get(0))); // contains只跟equals方法有关，即使元素取自于List
	}
}

class Car{
	private String name;

	public Car(String name) {
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
	public String toString() {
		return this.getName();
	}
	
	@Override
	public boolean equals(Object obj) {
		return this.name.equals(((Car)obj).getName());
	}
}