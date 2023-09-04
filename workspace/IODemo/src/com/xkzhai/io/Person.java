package com.xkzhai.io;

import java.io.Serializable;

public class Person implements Serializable{
	// 如不指定序列号，在修改类后会改变，从而影响反串行化
	private static final long serialVersionUID = -3342217940031109277L;
	private String name;
	private int age;
	private boolean married;
	
	public boolean isMarried() {
		return married;
	}
	
	public void setMarried(boolean married) {
		this.married = married;
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
	
	public Person(){
		System.out.println("构造函数....");
	}
	public Person(String name, int age) {
		System.out.println("构造函数....");
		this.name = name;
		this.age = age;
	}
	
}
