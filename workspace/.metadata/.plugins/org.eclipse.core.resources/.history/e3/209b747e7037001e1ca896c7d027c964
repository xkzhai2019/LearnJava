package com.xkzhai.io;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class FileReaderDemo {

	public static void main(String[] args) {
		FileReader fr = null;
		try{
			fr = new FileReader("hello.txt");
			char[] buffer = new char[3];
			while(true){
				int length = fr.read(buffer);
				// 到了流的末尾
				if(length==-1){
					break;
				}
				else{
					System.out.print(new String(buffer,0,length));
				}
			}
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
		}
		
		System.out.println("++++++++++++");
		try {
			fr = new FileReader("hello.txt");
			char[] buffer2 = new char[3];
			int len = -1;
			while((len = fr.read(buffer2))!=-1){
				System.out.print(new String(buffer2,0,len));
			}
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
		}
	}

}
