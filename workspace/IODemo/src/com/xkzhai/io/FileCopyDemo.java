package com.xkzhai.io;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

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

}