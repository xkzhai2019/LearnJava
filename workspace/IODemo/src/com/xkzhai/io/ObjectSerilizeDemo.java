package com.xkzhai.io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import org.junit.Test;

public class ObjectSerilizeDemo {
	
	public static void main(String[] args) throws Exception {
		// ���Ͷ���
		Integer i = new Integer(100);
		FileOutputStream fos = new FileOutputStream("integer.data");
		// ͨ���ļ������������������
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		// ���л�
		oos.writeObject(i);

		// �ر���,װ��ģʽ�£������������ιر�
		oos.close();
		// oos�Ѱ���fos�ر�
		fos.close();
		System.out.println("over");
	}
	
	/**
	 * ���л�
	 * @throws Exception
	 */
	@Test
	public void serializePerson() throws Exception {
		Person p = new Person("tom",12);
		FileOutputStream fos = new FileOutputStream("p.data");
		// ͨ���ļ������������������
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		// ���л�������ʵ��serializable�ӿڣ����ܴ��л�
		oos.writeObject(p);

		// �ر���,װ��ģʽ�£������������ιر�
		oos.close();
		// oos�Ѱ���fos�ر�
		fos.close();
		System.out.println("over");
	}
	
	/**
	 * �����л�
	 * @throws Exception
	 */
	@Test
	public void deSerializePerson() throws Exception {
		FileInputStream fis = new FileInputStream("p.data");
		// ͨ���ļ��������������������
		ObjectInputStream ois = new ObjectInputStream(fis);
		// �����л�
		Person p = (Person)ois.readObject();
		// �ر���,װ��ģʽ�£������������ιر�		
		ois.close();
		fis.close();
		System.out.println(p.getName()+":"+p.getAge()+":"+p.isMarried());
	}
}