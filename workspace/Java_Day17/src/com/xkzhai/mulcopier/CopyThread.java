package com.xkzhai.mulcopier;

import java.io.FileNotFoundException;
import java.io.RandomAccessFile;

/**
 * 复制线程
 * @author Administrator
 *
 */

public class CopyThread extends Thread{
	private String srcFile;
	private String destDir;
	private CopyUI copyui;
	
	private int start;
	private int end;

	public CopyThread(CopyUI copyui,String srcFile, String destDir, int start, int end) {
		this.copyui = copyui;
		this.srcFile = srcFile;
		this.destDir = destDir;
		this.start = start;
		this.end = end;
	}

	@Override
	public void run() {
		
		RandomAccessFile src;
		try {
			// 定位源文件
			src = new RandomAccessFile(srcFile, "r");
			src.seek(start);
			
			// 定位目标文件
			RandomAccessFile target = new RandomAccessFile(destDir, "rw");
			target.seek(start);
			
			byte[] buffer = new byte[1024];
			// 计算复制量
			int amount = end - start + 1;
			// 次数
			int loopNum = 0;
			// 剩余数
			int remain = amount % buffer.length;
			if(amount % buffer.length == 0){
				loopNum = amount / buffer.length;
			}
			else{
				loopNum = amount / buffer.length + 1;
			}
			int len = -1;
			for(int i = 0; i < loopNum; i++){
				//不是最后一次
				if (i != (loopNum - 1)){
					src.read(buffer);
					target.write(buffer);
					synchronized (CopyThread.class){
						copyui.bar.setValue(copyui.bar.getValue() + buffer.length);						
					}
				}
				else{
					byte[] buffer0 = null;
					if(remain == 0){
						buffer0 = buffer;
					}
					else{
						buffer0 = new byte[remain];
					}
					src.read(buffer0);
					target.write(buffer0);
					synchronized (CopyThread.class){
						copyui.bar.setValue(copyui.bar.getValue() + buffer0.length);		
					}
				}
			}
			src.close();
			target.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}

		
	}
}
