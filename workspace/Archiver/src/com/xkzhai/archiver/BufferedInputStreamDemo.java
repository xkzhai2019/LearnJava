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
	 * ʹ�û������ֽ�����ȡ�ļ�
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
	 * ʹ��ת������ȡ�ı����������ֽ�--->�ַ���
	 * @throws Exception 
	 * @throws UnsupportedEncodingException 
	 * �ײ����ֽ����������Ҫ����ת��Ϊ�ַ����ݴ���������ʹ��ת����
	 * װ��ģʽ
	 * ��Ҫָ��charSet
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
	 * ����system.out����׼���
	 * Ĭ��Ϊconsole
	 * �ı�ϵͳ��out����
	 */
	@Test
	public void sysoutTest() throws Exception{
		PrintStream ps = new PrintStream(new FileOutputStream("log.log"));
		// �ı�ϵͳ�������
		System.setOut(ps);
		System.out.println("log.log");
	}
	
	/**
	 * ����system.in����׼����
	 * Ĭ��Ϊ����
	 * �ӿ���̨��ȡ����
	 */
	@Test
	public void sysinTest() throws Exception{
		// �ı�ϵͳ����������
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