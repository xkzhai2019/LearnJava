package com.xkzhai.deepcopy;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class DeepCopy {

	public static void main(String[] args) throws Exception {
		Person p = new Person();
		Son s = new Son();
		Dog d = new Dog();
		Dog d1 = d;
		
		s.setPerson(p);
		d.setSon(s);
		
		// 串行化
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		ObjectOutputStream oos = new ObjectOutputStream(baos);
		System.out.println("d = " + d);
		System.out.println("d1 = " + d1);
		oos.writeObject(d);
		oos.writeObject(d1);
		oos.close();
		baos.close();
		
		// 反串行化
		ByteArrayInputStream bais = new ByteArrayInputStream(baos.toByteArray());
		ObjectInputStream ois = new ObjectInputStream(bais);
		Dog d3 = (Dog)ois.readObject();
		Dog d4 = (Dog)ois.readObject();
		System.out.println("d3 = "+ d3);
		System.out.println("d4 = "+ d4);
		
		bais.close();
		ois.close();
 
	}

}

class Person implements Serializable{

	private static final long serialVersionUID = 5569554546558917044L;
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}

class Son implements Serializable{
	private static final long serialVersionUID = -737043959801471082L;
	private String name;
	private Person person;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Person getPerson() {
		return person;
	}
	public void setPerson(Person person) {
		this.person = person;
	}
	
}

class Dog implements Serializable{
	private static final long serialVersionUID = -4538398406250952521L;
	private Son son;
	private String name;
	public Son getSon() {
		return son;
	}
	public void setSon(Son son) {
		this.son = son;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
}
