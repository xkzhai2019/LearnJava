package com.xkzhai.mulcopier2;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.List;

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
	// 每个线程复制信息的集合
	public List<CopyInfo> infos;
	public Copier(CopyUI copyui, String srcFile, String destDir, int count) {
		this.copyui = copyui;
		this.srcFile = srcFile;
		this.destDir = destDir;
		this.count = count;
		
		initCopyInfos();
	}


	/**
	 * 初始化复制信息的集合
	 * @throws Exception
	 */
	private void initCopyInfos(){
		infos = new ArrayList<CopyInfo>();
		int start = 0;
		int end = 0;
		
		// 计算源文件大小
		RandomAccessFile raf;
		try {
			raf = new RandomAccessFile(srcFile,"r");
		int fileLength = (int)raf.length();
		
		// 设置进度条最大值
		//copyui.bar.setMaximum(fileLength);
		
		// 每个线程复制的块大小
		int block = fileLength / count;
		
		for(int i = 0; i < count; i++){
			CopyInfo info = new CopyInfo();
			//设置索引
			info.setIndex(i);
			info.setSrcFile(srcFile);
			info.setDestDir(destDir);
			start = i* block;
			info.setStart(start);
			if(i != count - 1){
				end = (i+1)*block - 1;
			}
			else{
				end = fileLength - 1;
			}
			info.setEnd(end);
			infos.add(info);
		}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}


	/**
	 * 开始复制文件 
	 * @throws IOException
	 */

	public void startCopy(){
		for(CopyInfo info: infos){
			new CopyThread(copyui,info).start();
		}
	}
}
