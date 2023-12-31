package com.xkzhai.io;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.LineNumberReader;

import org.junit.Test;
/**
 * 文档注释
 * @author Administrator
 *
 */
public class BufferedWriterDemo2 {
	/**
	 * 十六进制正负数问题和二进制内存存储的区别
	 * 128 ====== 0x80 ==== 0200 
	 */
	@Test
	public void hexNum(){
		int i = 5;
		i = 0x5;
		i = -0x80;
		byte b = -0x80;
		System.out.println(i);
		
	}
	/**
	 * 使用缓冲区写入文件
	 *
	 */
	@Test
	public void writeFileWithBuffered() throws Exception {
		int size = 1024;
		for(int i=1;i<=1024*32;i = i *2){
			long start = System.currentTimeMillis();
			BufferedWriter bw = new BufferedWriter(new FileWriter("hello.txt"),i*size);
			for(int j=0;j<4;j++){
				bw.write("abc中bcdabc中bcdabc中bcdabc中bcd");
			}
			bw.close();
			long duration = System.currentTimeMillis() - start;
			System.out.println(i+"k:"+duration);
		}

	}
	
	/**
	 * JUint单元测试
	 * 不能有返回值、不能有参数、不能由static修饰
	 * import org.junit.Test;
	 */
	@Test
	public void readFileNoBuffered() throws Exception{
		FileReader fr = new FileReader("hello.txt");
		long start = System.currentTimeMillis();
//		System.out.println((char)fr.read());
//		System.out.println((char)fr.read());
//		System.out.println((char)fr.read());
//		System.out.println((char)fr.read());
//		System.out.println((char)fr.read());
//		System.out.println((char)fr.read());
//		System.out.println((char)fr.read());
		while((fr.read())!=-1){
		}
		fr.close();
		System.out.println(System.currentTimeMillis() - start);
	}
	
	/**
	 * 测试BufferedReader
	 * @throws Exception 
	 */
	@Test
	public void readFileWithBuffered() throws Exception{
		int size = 1024;
		for(int i=1;i<=1024*32;i = i *2){
			long start = System.currentTimeMillis();
			BufferedReader br = new BufferedReader(new FileReader("hello.txt"),i*size);
			while((br.read())!=-1){
			}
			br.close();
			System.out.println(i+"k:"+(System.currentTimeMillis() - start));
		}
	}
	
	/**
	 * 测试BufferedReader
	 * @throws Exception 
	 */
	@Test
	public void readFileWithBuffered2() throws Exception{
		long start = System.currentTimeMillis();
		BufferedReader br = new BufferedReader(new FileReader("hello.txt"));
		char[] cbuf = new char[128000000];
		br.read(cbuf);
		br.close();
		System.out.println(System.currentTimeMillis() - start);
	}
	
	/**
	 * readline
	 * 不含行结束符
	 * @throws Exception
	 */
	@Test
	public void readLineWithBuffered() throws Exception{
		BufferedReader br = new BufferedReader(new FileReader("hello.txt"));
		String line = null;
		while((line=br.readLine())!=null){
			System.out.println(line);
			System.out.println();
		}
		br.close();
	}
	
	/**
	 * LineNumber
	 * @throws Exception
	 */
	@Test
	public void lineNumberReaderTest() throws Exception{
		LineNumberReader br = new LineNumberReader(new FileReader("hello.txt"));
		String line = null;
		System.out.println(br.getLineNumber());
		br.setLineNumber(100);
		while((line=br.readLine())!=null){
			System.out.println(br.getLineNumber());
		}
		br.close();
	}

}
