package com.xkzhai.io;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class BufferedWriterDemo {

	public static void main(String[] args) {
		try {
			String line = System.getProperty("line.separator");
			
			BufferedWriter bw = new BufferedWriter(new FileWriter("hello.txt"));
			bw.write("hello"+line);
			bw.write("hello2"+line);
			bw.write("hello3"+line);
			bw.write("hello4"+line);
			bw.write("hello5"+line);
			bw.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
