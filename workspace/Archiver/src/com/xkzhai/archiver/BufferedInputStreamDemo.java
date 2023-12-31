package com.xkzhai.archiver;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.io.UnsupportedEncodingException;

import org.junit.Test;

public class BufferedInputStreamDemo {
	
	
	/**
	 * 使用缓冲区字节流读取文件
	 * @throws Exception
	 */
	@Test
	public void bufferedInputStream() throws Exception {
		BufferedInputStream in = new BufferedInputStream(new FileInputStream("a.txt"));
		int i = -1;
		while((i = in.read())!=-1){
			System.out.println(i);
		}
		in.close();
	}
	
	
	/**
	 * 使用转换流读取文本，桥梁（字节--->字符）
	 * @throws Exception 
	 * @throws UnsupportedEncodingException 
	 * 底层是字节流，如果需要将其转换为字符内容处理，即可使用转换流
	 * 装饰模式
	 * 需要指定charSet
	 */
	@Test
	public void InputStreamReaderDemo() throws UnsupportedEncodingException, Exception{
		InputStreamReader reader = new InputStreamReader(new FileInputStream("1.txt"),"utf-8");
		
		char[] buffer = new char[1024];
		int len = -1;
		while((len=reader.read(buffer)) != -1){
			System.out.println(new String(buffer,0,len));
		}
		reader.close();
	}
	
	@Test
	public void readInByte() throws UnsupportedEncodingException, Exception{
		FileInputStream fin = new FileInputStream("1.txt");
		
		byte[] buffer = new byte[1024];
		int len = -1;
		while((len=fin.read(buffer)) != -1){
			System.out.println(new String(buffer,0,len));
		}
		fin.close();
	}
	
	/**
	 * 考查system.out，标准输出
	 * 默认为console
	 * 改变系统的out流向
	 */
	@Test
	public void sysoutTest() throws Exception{
		PrintStream ps = new PrintStream(new FileOutputStream("log.log"));
		// 改变系统输出流向
		System.setOut(ps);
		System.out.println("log.log");
	}
	
	/**
	 * 考查system.in，标准输入
	 * 默认为键盘
	 * 从控制台读取输入
	 */
	@Test
	public void sysinTest() throws Exception{
		// 改变系统输入流方向
		System.setIn(new FileInputStream("hello.txt"));
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		while(true){
			String line = reader.readLine();
			if("exit".equals(line)){
				System.exit(-1);
			}
			System.out.println(line);
		}
	}
}
