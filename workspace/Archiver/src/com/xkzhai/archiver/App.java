package com.xkzhai.archiver;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;

import org.junit.Test;

public class App {

	/**
	 * 新建归档文件
	 */
	@Test
	public void newArchiverFile(){
		String path = "home/xkzhai/hello.txt";
		System.out.println(path.substring(path.lastIndexOf(".")));
		
		Archiver archiver = new Archiver();
		String[] srcPaths = {
				"1.jpg",
				"hello.txt",
				"myyar.yar"
		};
		String yarPath = "newyar.yar";
		archiver.newArachiverFile(srcPaths, yarPath);
		System.out.println("over");
	}
	
	/**
	 * 向原有归档文件中添加新文件
	 */
	@Test
	public void addFile(){
		Archiver archiver = new Archiver();
		archiver.appendFile("hello_copy.txt", "myyar.yar");
		System.out.println("over");
	}
	
	/**
	 * 解档yar文件
	 */
	@Test
	public void unarchiveFile(){
		Archiver archiver = new Archiver();
		archiver.unarchive("unarch/3.yar", "unarch/tmp");
		System.out.println("over");
	}
	
	/**
	 * 使用文本文件存储媒体文件
	 * @throws Exception 
	 */
	@Test
	public void readJPG() throws Exception{
		FileOutputStream fos = new FileOutputStream("a.txt");
		FileInputStream fis = new FileInputStream("1.jpg");
		int b = -1;
		while((b=fis.read())!=-1){
			fos.write((b + "").getBytes());
			fos.write(new byte[]{'\r','\n'});
		}
		fos.close();
		fis.close();
	}
	
	/**
	 * 读取媒体文件
	 */
	@Test
	public void writeJPG(){
		
	}
	
	/**
	 * 使用文本文件存储媒体文件
	 * @throws Exception 
	 */
	@Test
	public void readJPG2() throws Exception{
		FileWriter writer = new FileWriter("b.txt");
		FileInputStream fis = new FileInputStream("1.jpg");
		int len = -1;
		byte[] buffer = new byte[1024];
		
		while((len=fis.read(buffer))!=-1){
			writeByteArrToFile(buffer,0,len,writer);
		}
		writer.close();
		fis.close();
	}
	/**
	 * 将字节数组中的字节数写入到fos中
	 */
	private void writeByteArrToFile(byte[] arr, int beginIndex, int length, FileWriter writer){
		
		try{
			for(int j=beginIndex;j<length;j++ ){
				writer.write(arr[j]+"\r\n");
			}	
		}catch(Exception e){
			e.printStackTrace();
		}
		

	}
	
	/**
	 * 读取文本文件，恢复图像
	 */
	@Test
	public void readTxt2JPG(){
		try {
			BufferedReader reader = new BufferedReader(new FileReader("a.txt"));
			FileOutputStream fos = new FileOutputStream("2.jpg");
			String line = null;
			// 循环读行
			while((line = reader.readLine())!=null){
				// 把每行数字变换成byte
				byte b = (byte)Integer.parseInt(line);
				//fos.write(b);
				//fos.write(new byte[]{b});
				fos.write(Integer.parseInt(line));
			}
			fos.close();
			reader.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
