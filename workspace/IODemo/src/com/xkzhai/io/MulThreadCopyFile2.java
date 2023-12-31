package com.xkzhai.io;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

public class MulThreadCopyFile2 {
	
	public static int i = 0;
	public static int block = 0;
	public static void main(String[] args) throws Exception {
		// 源文件
		File srcFile = new File("dupliFile.txt");
		RandomAccessFile srcRaf = new RandomAccessFile(srcFile,"rw");
		int srcLength = (int)srcFile.length();
		// 目标文件
		File destFile = new File("MulThreadCopyFile.txt");
		RandomAccessFile destRaf = new RandomAccessFile(destFile,"rw");
		destRaf.setLength(srcLength);
		
		// 使用线程数
		int count = 3;
		// 计算每个线程复制的文件块大小
		block = srcLength / count;
//		if(srcLength % count == 0){
//			block = srcLength / count;
//		}
//		else{
//			block = srcLength / count +1;
//		}
		// 开启count个线程
		for(i = 0;i < count; i++){
			Thread t = new Thread(){
					public void run() {
						int tmp = i;
						int start = tmp*block;
						int end = 0;
						// 是否是最后一个线程
						if(tmp!=(count-1)){
							end = (tmp+1)*block - 1;
						}else{
							end = srcLength - 1;
						}
						try {
							// 定位文件指针
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
