package com.xkzhai.mulcopier2;

import java.io.FileNotFoundException;
import java.io.RandomAccessFile;

/**
 * �����߳�
 * @author Administrator
 *
 */

public class CopyThread extends Thread{
	private CopyUI copyui;
	private CopyInfo info;

	public CopyThread(CopyUI copyui,CopyInfo info) {
		this.copyui = copyui;
		this.info = info;
	}

	@Override
	public void run() {
		
		RandomAccessFile src;
		try {
			// ��λԴ�ļ�
			src = new RandomAccessFile(info.getSrcFile(), "r");
			src.seek(info.getStart());
			
			// ��λĿ���ļ�
			RandomAccessFile target = new RandomAccessFile(info.getDestDir(), "rw");
			target.seek(info.getStart());
			
			byte[] buffer = new byte[1024];
			// ���㸴����
			int amount = info.getEnd() - info.getStart() + 1;
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
					copyui.updateBar(info.getIndex(),buffer.length);
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
					copyui.updateBar(info.getIndex(),buffer0.length);
				}
			}
			src.close();
			target.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}

		
	}
}