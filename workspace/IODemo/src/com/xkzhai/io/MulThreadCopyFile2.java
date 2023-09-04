package com.xkzhai.io;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

public class MulThreadCopyFile2 {
	
	public static int i = 0;
	public static int block = 0;
	public static void main(String[] args) throws Exception {
		// Դ�ļ�
		File srcFile = new File("dupliFile.txt");
		RandomAccessFile srcRaf = new RandomAccessFile(srcFile,"rw");
		int srcLength = (int)srcFile.length();
		// Ŀ���ļ�
		File destFile = new File("MulThreadCopyFile.txt");
		RandomAccessFile destRaf = new RandomAccessFile(destFile,"rw");
		destRaf.setLength(srcLength);
		
		// ʹ���߳���
		int count = 3;
		// ����ÿ���̸߳��Ƶ��ļ����С
		block = srcLength / count;
//		if(srcLength % count == 0){
//			block = srcLength / count;
//		}
//		else{
//			block = srcLength / count +1;
//		}
		// ����count���߳�
		for(i = 0;i < count; i++){
			Thread t = new Thread(){
					public void run() {
						int tmp = i;
						int start = tmp*block;
						int end = 0;
						// �Ƿ������һ���߳�
						if(tmp!=(count-1)){
							end = (tmp+1)*block - 1;
						}else{
							end = srcLength - 1;
						}
						try {
							// ��λ�ļ�ָ��
							destRaf.seek(start);
							srcRaf.seek(start);
							int bufSize = end - start + 1;
							byte[] buf = new byte[bufSize];
							srcRaf.read(buf);
							destRaf.write(buf);		
							System.out.println(tmp+":over");
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				};
				t.start();
				//t.join();
		}
		Thread.sleep(1000);
		System.out.println("over");
		srcRaf.close();
	}

}