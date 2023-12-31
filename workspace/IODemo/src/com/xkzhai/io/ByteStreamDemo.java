package com.xkzhai.io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.nio.charset.Charset;

import org.junit.Test;

public class ByteStreamDemo {

	/**
	 * 使用字节流复制图片
	 * @throws Exception 
	 */
	@Test
	public void copyImg() throws Exception{
		// 文件输入流（字节流）
		FileInputStream fin = new FileInputStream("1.jpg");
		// 文件输出流（字节流）
		FileOutputStream fout = new FileOutputStream("2.jpg");
		byte[] buffer = new byte[1024];
		//fin.read(buffer);
		int len = -1;
		while((len=fin.read(buffer)) != -1){
			fout.write(buffer,0,len);
		}
		fin.close();
		fout.close();
		System.out.println("over");
	}
	/**
	 * 使用文件输出流写入文本文件
	 * @throws Exception 
	 */
	@Test
	public void writeFileWithFOUT() throws Exception{
		System.out.println(Charset.defaultCharset());
		String str = "你hello";
		FileOutputStream fout = new FileOutputStream("hello.txt");
		//编码: utf-8使用3个字节存储汉字
		//fout.write(str.getBytes("utf-8")); 
		
		// GBK使用两个字节存储汉字；
		fout.write(str.getBytes("GBK")); 
		
		// ISO将汉字识别为?
		//fout.write(str.getBytes("ISO-8859-1")); 
		
		System.out.println(str.getBytes("GBK").length);
		fout.close();
		System.out.println("over");
	}
	
	/**
	 * 使用文件输入流读取文件
	 * @throws Exception
	 */
	@Test
	public void readFileWithFIN() throws Exception{

		FileInputStream fin = new FileInputStream("hello.txt");
		char c = (char)fin.read();
		System.out.println(c);
		fin.close();
		System.out.println("over");
	}
	
	/**
	 * 跳过字节
	 * @throws Exception 
	 */
	@Test
	public void skipByteTest() throws Exception{
		FileInputStream fin = new FileInputStream("hello.txt");
		int c = -1;
		// 文件长度
		System.out.println(fin.available());
		// 1....1 1111 1111
		//&0....0 1111 1111 <----> 0xff
		//---------------------
		while( (c = fin.read())!=-1){
			// 文件输入流: skip可以跳过文件尾，不可以跳出文件头
			// 文件输出流：不支持skip
			fin.skip(1);
			//fin.skip(-10);
			System.out.print((char)c);
		}
		
		fin.close();
	}

}
