package com.xkzhai.io;

import java.io.Serializable;

public class Person implements Serializable{
	// �粻ָ�����кţ����޸�����ı䣬�Ӷ�Ӱ�췴���л�
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
		System.out.println("���캯��....");
	}
	public Person(String name, int age) {
		System.out.println("���캯��....");
		this.name = name;
		this.age = age;
	}
	
}
