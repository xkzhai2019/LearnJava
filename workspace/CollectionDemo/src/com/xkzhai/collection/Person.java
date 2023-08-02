package com.xkzhai.collection;
/**
 * Person
 * */
public class Person {
	private String name;
	private int age;
	public Person() {
	}
	
	public Person(String name, int age) {
		this.name = name;
		this.age = age;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	@Override
	public boolean equals(Object obj) {
		// 1. obj == null ?
		if(obj==null){
			return false;
		}
		// 2. this == obj ?
		if(this==obj){
			return true;
		}
		// 3. obj是否为Person实例
		if(obj instanceof Person){
			Person p0 = (Person)obj;
//			if(this.name.equals(p0.getName()) && this.age == p0.getAge()){
//				return true;
//			}
			// 1) 定义变量，存放name是否相等
			boolean nameEqu = false;
			if(name==null){
				if(p0.name == null){
					nameEqu = true;
				}
				else{
					nameEqu = false;
				}
			}
			else{
				nameEqu = name.equals(p0.name);
			}
			// 2) 年龄是否相同
			boolean ageEqu = (this.age == p0.age);
			return nameEqu && ageEqu;
		}
		return false;
	}
}
