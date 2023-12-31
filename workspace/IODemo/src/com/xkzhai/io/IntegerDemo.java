package com.xkzhai.io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import org.junit.Test;

public class IntegerDemo {
	
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
	public void serialize() throws Exception {
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
	 * 反串行化
	 * @throws Exception
	 */
	@Test
	public void deSerialize() throws Exception {
		FileInputStream fis = new FileInputStream("integer.data");
		// 通过文件输入流构造对象输入流
		ObjectInputStream ois = new ObjectInputStream(fis);
		// 反序列化
		Integer i = (Integer)ois.readObject();
		// 关闭流,装饰模式下，从外向里依次关闭		
		ois.close();
		fis.close();
		System.out.println(i);
	}
}
