package com.xkzhai.io;

import java.io.FileWriter;
import java.io.IOException;

public class FileWriterDemo {

	public static void main(String[] args) {
//		try {
//			FileWriter fw = new FileWriter("hello.txt");
//			// 写入字符数据到流中
//			fw.write("hello world");
//			
//			// 清理流，将流中数据写入到目标设备上
//			//fw.flush();
//			
//			// 关闭流，隐含flush()操作
//			fw.close();
//			// 关闭流后，无法再写入
//			// fw.write("how are you");
//			
//			System.out.println("over");
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
		FileWriter fw = null;
		try {
			//fw = new FileWriter("hello.txt");
			fw = new FileWriter("hello.txt",true);
			// 写入字符数据到流中
			//fw.write("hello world");
			//fw.write("hello world0000");
			fw.write("\r\n how are you");
			System.out.println("over");
		} catch (IOException e) {
			e.printStackTrace();
		}
		finally{
			try {
				if(fw!=null){
					// 重复关闭不会发生错误
					fw.close();
					fw.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}
