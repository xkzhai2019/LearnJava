package com.xkzhai.io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import org.junit.Test;

public class IntegerDemo {
	
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
	public void serialize() throws Exception {
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
	 * �����л�
	 * @throws Exception
	 */
	@Test
	public void deSerialize() throws Exception {
		FileInputStream fis = new FileInputStream("integer.data");
		// ͨ���ļ��������������������
		ObjectInputStream ois = new ObjectInputStream(fis);
		// �����л�
		Integer i = (Integer)ois.readObject();
		// �ر���,װ��ģʽ�£������������ιر�		
		ois.close();
		fis.close();
		System.out.println(i);
	}
}