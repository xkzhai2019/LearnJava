package com.xkzhai.mulcopier;

import java.io.FileNotFoundException;
import java.io.RandomAccessFile;

/**
 * �����߳�
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
			// ��λԴ�ļ�
			src = new RandomAccessFile(srcFile, "r");
			src.seek(start);
			
			// ��λĿ���ļ�
			RandomAccessFile target = new RandomAccessFile(destDir, "rw");
			target.seek(start);
			
			byte[] buffer = new byte[1024];
			// ���㸴����
			int amount = end - start + 1;
			// ����
			int loopNum = 0;
			// ʣ����
			int remain = amount % buffer.length;
			if(amount % buffer.length == 0){
				loopNum = amount / buffer.length;
			}
			else{
				loopNum = amount / buffer.length + 1;
			}
			int len = -1;
			for(int i = 0; i < loopNum; i++){
				//�������һ��
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