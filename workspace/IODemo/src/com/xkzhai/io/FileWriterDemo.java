package com.xkzhai.io;

import java.io.FileWriter;
import java.io.IOException;

public class FileWriterDemo {

	public static void main(String[] args) {
//		try {
//			FileWriter fw = new FileWriter("hello.txt");
//			// д���ַ����ݵ�����
//			fw.write("hello world");
//			
//			// ������������������д�뵽Ŀ���豸��
//			//fw.flush();
//			
//			// �ر���������flush()����
//			fw.close();
//			// �ر������޷���д��
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
			// д���ַ����ݵ�����
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
					// �ظ��رղ��ᷢ������
					fw.close();
					fw.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}