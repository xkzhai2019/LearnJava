package com.xkzhai.io;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.RandomAccessFile;

import org.junit.Test;

/**
 * ��������ļ�
 * @author Administrator
 *
 */
public class RandomAccessFileDemo {
	public static void main(String[] args) throws Exception {
		RandomAccessFile raf = new RandomAccessFile("raf.txt","rwd");
		raf.write("hel��lo world".getBytes());
		
		System.out.println("over");
		
		// ���Զ�λ�ļ�
		raf.seek(3);
		int c = -1;
		while((c = raf.read())!=-1){
			System.out.print((char)c);
		}
		raf.close();
	}
	
	/**
	 * �ļ������ظ�
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