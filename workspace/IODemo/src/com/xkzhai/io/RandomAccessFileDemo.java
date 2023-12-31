package com.xkzhai.io;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.RandomAccessFile;

import org.junit.Test;

/**
 * 随机访问文件
 * @author Administrator
 *
 */
public class RandomAccessFileDemo {
	public static void main(String[] args) throws Exception {
		RandomAccessFile raf = new RandomAccessFile("raf.txt","rwd");
		raf.write("hel中lo world".getBytes());
		
		System.out.println("over");
		
		// 绝对定位文件
		raf.seek(3);
		int c = -1;
		while((c = raf.read())!=-1){
			System.out.print((char)c);
		}
		raf.close();
	}
	
	/**
	 * 文件内容重复
	 * @throws Exception 
	 */
	@Test
	public void duplicateFile() throws Exception{
		RandomAccessFile raf = new RandomAccessFile("raf.txt","rwd");
		FileOutputStream fos = new FileOutputStream("dupliFile.txt");
		
		byte[] buffer = new byte[1024];
		int len = -1;
		while((len = raf.read(buffer)) != -1){
			fos.write(buffer, 0, len);
		}
		raf.seek(0);
		while((len = raf.read(buffer)) != -1){
			fos.write(buffer, 0, len);
		}
		raf.seek(0);
		while((len = raf.read(buffer)) != -1){
			fos.write(buffer, 0, len);
		}
		fos.close();
		raf.close();
	}
}
