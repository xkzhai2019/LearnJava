package com.xkzhai.io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import org.junit.Test;

public class ObjectSerilizeDemo {
	
	public static void main(String[] args) throws Exception {
		// 整型对象
		Integer i = new Integer(100);
		FileOutputStream fos = new FileOutputStream("integer.data");
		// 通过文件输出流构造对象输出流
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		// 序列化
		oos.writeObject(i);

		// 关闭流,装饰模式下，从外向里依次关闭
		oos.close();
		// oos已包含fos关闭
		fos.close();
		System.out.println("over");
	}
	
	/**
	 * 串行化
	 * @throws Exception
	 */
	@Test
	public void serializePerson() throws Exception {
		Person p = new Person("tom",12);
		System.out.println(p);
		FileOutputStream fos = new FileOutputStream("p.data");
		// 通过文件输出流构造对象输出流
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		// 序列化：必须实现serializable接口，方能串行化
		oos.writeObject(p);

		// 关闭流,装饰模式下，从外向里依次关闭
		oos.close();
		// oos已包含fos关闭
		fos.close();
		System.out.println("over");
	}
	
	/**
	 * 反串行化
	 * @throws Exception
	 */
	@Test
	public void deSerializePerson() throws Exception {
		FileInputStream fis = new FileInputStream("p.data");
		// 通过文件输入流构造对象输入流
		ObjectInputStream ois = new ObjectInputStream(fis);
		// 反序列化
		Person p = (Person)ois.readObject();
		// 反序列化时，不经过构造函数，因为没有必要
		System.out.println(p);
		// 关闭流,装饰模式下，从外向里依次关闭		
		ois.close();
		fis.close();
		System.out.println(p.getName()+":"+p.getAge()+":"+p.isMarried());
	}
}
