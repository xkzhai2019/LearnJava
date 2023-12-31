package com.xkzhai.collection;

import java.util.HashSet;
import java.util.Set;

public class StudentDemo2 {
	public static void main(String[] args) {
		Set<Student2> students = new HashSet<Student2>();
		students.add(new Student2((byte)-2,(byte)11,(byte)12));
		students.add(new Student2((byte)11,(byte)12,(byte)13));
		students.add(new Student2((byte)12,(byte)13,(byte)14));
		students.add(new Student2((byte)12,(byte)13,(byte)14));
		Student2 s = new Student2((byte)-128,(byte)-127,(byte)-126);
		students.add(s);
		System.out.println(students.size());
		System.out.println(Integer.toBinaryString(s.hashCode()));
	}
}

class Student2{
	private byte age;
	private byte height;
	private byte weigth;
	public byte getAge() {
		return age;
	}
	public void setAge(byte age) {
		this.age = age;
	}
	public byte getHeight() {
		return height;
	}
	public void setHeight(byte height) {
		this.height = height;
	}
	public byte getWeigth() {
		return weigth;
	}
	public void setWeigth(byte weigth) {
		this.weigth = weigth;
	}
	public Student2(byte age, byte weigth,byte height) {
		this.age = age;
		this.height = height;
		this.weigth = weigth;
	}
	
	@Override
	public int hashCode() {
		int hash = (this.age & 0xFF)  | (this.weigth & 0xFF) << 8 | (this.height & 0xFF) << 16;
		return hash;
	}
	@Override
	public boolean equals(Object obj) {
		if(obj==null){
			return false;
		}
		if(this==obj){
			return true;
		}
		if(obj instanceof Student2){
			Student2 o = (Student2)obj;
			return o.hashCode() == this.hashCode();
		}
			
		return false;
	}
	
}
