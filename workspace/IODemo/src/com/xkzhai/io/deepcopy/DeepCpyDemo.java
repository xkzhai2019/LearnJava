package com.xkzhai.io.deepcopy;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

import org.junit.Test;

/**
 * ��ȸ��ƣ����Ƶ�����������ͼ
 * @author Administrator
 *
 */
public class DeepCpyDemo {
	
	
	/**
	 * ʹ��ByteArrayOutputStream + ByteArrayInputStreamʵ�ֶ���ͼ����ȸ���
	 * @throws Exception 
	 */
	@Test
	public void deeplyCopyInBAOS() throws Exception{
		Person p = new Person();
		Son s = new Son();
		Dog d = new Dog();
		
		// ���ù�����ϵ
		s.setPerson(p);
		d.setSon(s);
		
		// ���л����ڴ���
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		ObjectOutputStream oos = new ObjectOutputStream(baos);
		oos.writeObject(d);
		oos.close();
		baos.close();
		
		byte[] bytes = baos.toByteArray();
		// �����л�����ȡ�ڴ��е�����
		ByteArrayInputStream bais = new ByteArrayInputStream(bytes);
		ObjectInputStream ois = new ObjectInputStream(bais);
		Dog dd = (Dog)ois.readObject();
		System.out.println(dd.getSon());
		ois.close();
		bais.close();
	}
	/**
	 * ����д������
	 */
	@Test
	public void continusWrite() throws Exception{
		Person p = new Person();
		p.setName("jerry");
		
		Son s = new Son();
		s.setName("tom");
		
		Dog d = new Dog();
		d.setName("yellow");
		
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		ObjectOutputStream oos = new ObjectOutputStream(baos);
		oos.writeObject(p);
		oos.writeObject(s);
		oos.writeObject(d);
		oos.close();
		
		byte[] bytes = baos.toByteArray();
		ObjectInputStream ois = new ObjectInputStream(new ByteArrayInputStream(bytes));
		Person p2 = (Person)ois.readObject();
		Son s2 = (Son)ois.readObject();
		Dog d2 = (Dog)ois.readObject();
		
		ois.close();
		System.out.println(p2.getName());
		System.out.println(s2.getName());
		System.out.println(d2.getName());
		
	}
	
	@Test
	public void Serialize() throws Exception {
		Person p = new Person();
		Son s = new Son();
		Dog d = new Dog();
		
		// ���ù�����ϵ
		s.setPerson(p);
		d.setSon(s);
		
		// ���л�
		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("copy.data"));
		oos.writeObject(d);
		oos.close();
		System.out.println("over");
		
	}
	
	@Test
	public void deSerialize() throws Exception {
		// �����л�
		ObjectInputStream oos = new ObjectInputStream(new FileInputStream("copy.data"));
		Dog d = (Dog)oos.readObject();
		oos.close();
		System.out.println(d.getSon());
		
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
	// transient: ��ʱ�ģ���ʱ��
	private transient Person person;
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