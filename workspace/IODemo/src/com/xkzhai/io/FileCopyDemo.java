package com.xkzhai.io;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import org.junit.Test;

public class FileCopyDemo {

	public static void main(String[] args) {
		FileReader fr = null;
		FileWriter fw = null;
		int len = 0;
	
		try {
			fr = new FileReader("hello.txt");
			fw = new FileWriter("hello_copy.txt",false);
			
			char[] buffer = new char[3];
			while((len=fr.read(buffer))!=-1){
				fw.write(new String(buffer,0,len));
				//fw.write(new String(buffer));
				//fw.flush();
			}
			System.out.println("over");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally{
			if(fr!=null){
				try {
					fr.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(fw!=null){
				try {
					fw.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		

	}
	
	@Test
	public void FileTest(){
		File f = new File("hello.txt");
		// 文件长度
		long len = f.length();
		System.out.println(len);
		//得到上级目录
		String str = f.getParent();
		System.out.println(str);
		
		System.out.println("canWrite():"+f.canWrite());
		
		File[] fs = new File("C:\\LearnJava\\workspace\\Archiver").listFiles();
		System.out.println(fs.length);
		
		// 重命名文件
		f.renameTo(new File("hello.txt","hello2.txt"));
		System.out.println("over");
		
		// 列出文件系统的root
		File[] fs2 = File.listRoots();
		for(File f0: fs2){
			System.out.println(f0.getAbsolutePath());
		}
	}

}
