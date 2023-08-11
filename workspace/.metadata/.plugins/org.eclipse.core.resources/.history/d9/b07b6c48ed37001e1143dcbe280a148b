package com.xkzhai.io;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class FileWriterVSBufferedWriter {

	public static void main(String[] args) {
		// FileWriter
		try {
			long l = System.currentTimeMillis();
			FileWriter fw = new FileWriter("hello.txt");
			for(int i=0;i<10;i++){
				fw.write(i+"");
			}
			fw.close();
			System.out.println(System.currentTimeMillis() - l);
		} catch (IOException e) {
			e.printStackTrace();
		}

		// BufferedWriter
		try {
			long l = System.currentTimeMillis();
			BufferedWriter bw = new BufferedWriter(new FileWriter("hello.txt"));
			for(int i=0;i<10;i++){
				bw.write(i+"");
			}
			bw.close();
			System.out.println(System.currentTimeMillis() - l);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
