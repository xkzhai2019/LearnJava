package com.xkzhai.mulcopier;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * 复制器
 * @author Administrator
 *
 */
public class Copier {
	// 源文件
	private String srcFile;
	// 目标目录
	private String destDir;
	// 线程数
	private int count;
	
	private CopyUI copyui; 
	
	public Copier(CopyUI copyui, String srcFile, String destDir, int count) {
		this.copyui = copyui;
		this.srcFile = srcFile;
		this.destDir = destDir;
		this.count = count;
	}


	/**
	 * 开始复制文件 
	 * @throws IOException
	 */

	public void startCopy() throws IOException{
		int start = 0;
		int end = 0;
		
		// 计算源文件大小
		RandomAccessFile raf = new RandomAccessFile(srcFile,"r");
		int fileLength = (int)raf.length();
		
		// 设置进度条最大值
		copyui.bar.setMaximum(fileLength);
		
		// 每个线程复制的块大小
		int block = fileLength / count;
		
		for(int i = 0; i < count; i++){
			start = i* block;
			if(i != count - 1){
				end = (i+1)*block - 1;
			}
			else{
				end = fileLength - 1;
			}
			new CopyThread(copyui, srcFile,destDir, start,end).start();
		}
	}
}
