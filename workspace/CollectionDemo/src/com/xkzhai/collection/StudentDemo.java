package com.xkzhai.collection;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class StudentDemo {
	public static void main(String[] args) {
		Set<Student> students = new HashSet<Student>();
		students.add(new Student(10,257,257));
		students.add(new Student(10,257,257));
		students.add(new Student(11,10,12));
		students.add(new Student(12,11,10));
		System.out.println(students.size());
		
		System.out.println(Integer.toBinaryString((new Student(12,13,14)).hashCode()));
		
		System.out.println(students.contains(new Student(12,11,10)));
	}
}

class Student implements Comparable<Student>{
	private int height;
	private int weight;
	private int age;
	public int getHeight() {
		return height;
	}
	public void setHeight(int height) {
		this.height = height;
	}
	public int getWeight() {
		return weight;
	}
	public void setWeight(int weight) {
		this.weight = weight;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public Student(int height, int weight, int age) {
		this.height = height;
		this.weight = weight;
		this.age = age;
	}
	
	@Override
	public int hashCode() {
		//return (this.height & 0xFF) + ((this.weight  & 0xFF)<< 8)+(( this.age& 0xFF)<< 16);
		return this.height | this.weight << 8 | this.age << 16;
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj==null){
			return false;
		}
		if(this==obj){
			return true;
		}
		if(obj instanceof Student){
			Student s = (Student)obj;
			int thisHash = this.hashCode();
			int sHash = s.hashCode();
			return thisHash==sHash;
		}
		return false;
	}
	@Override
	public int compareTo(Student o) {
		if(o==null){
			return 1;
		}
		return this.height - o.height;
	} 
	@Override
	public String toString() {	
		return "Student("+ height + ","+ weight+","+age+")";
	}
}
