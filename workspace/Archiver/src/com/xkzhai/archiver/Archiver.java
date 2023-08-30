package com.xkzhai.archiver;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Archiver {
	/**
	 * �����鵵�ļ�
	 */
	public void newArachiverFile(String[] srcPaths,String yarPath){
		FileOutputStream fout = null;
		try {
			fout = new FileOutputStream(yarPath);
			for(String srcPath: srcPaths){
				// ��yar�鵵�ļ��������ļ�
				appendFile(srcPath,fout);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally{
			if(fout!=null){
				try {
					fout.close();
				} catch (IOException e) {
					e.printStackTrace();
				}				
			}
		}
	}
	
	/**
	 * ��yar�鵵�ļ��������ļ�
	 * @param srcPath
	 * @param fout
	 * @throws Exception 
	 */
	private void appendFile(String srcPath, FileOutputStream fout){
		FileInputStream fin = null;
		try {
			//1. ȡ��srcPath�ļ�����
			int fType = getFileType(srcPath);
			
			//2. ȡ��srcPath�ļ�����
			fin = new FileInputStream(srcPath);
			int length = fin.available();
			
			//3. ��fTypeд��fout
			byte bFtype = (byte)fType;
			fout.write(new byte[]{bFtype});
			
			//4. ������д��fout
			byte[] bytes = int2byteArr(length);
			fout.write(bytes);
			
			//5. д���ļ�����
			int len = -1;
			byte[] buffer = new byte[1024];
			while((len=fin.read(buffer))!=-1){
				fout.write(buffer, 0, len);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
			if(fin!=null){
				try {
					fin.close();
				} catch (IOException e) {
					e.printStackTrace();
				}				
			}
		}
		
	}
	/**
	 * ������ת��Ϊ�ֽ�����
	 * @param length
	 * @return
	 */
	private byte[] int2byteArr(int i) {
		byte[] bytes = new byte[4];
		bytes[0] = (byte)(i);
		bytes[1] = (byte)(i >> 8);
		bytes[2] = (byte)(i >> 16);
		bytes[3] = (byte)(i >> 24);
		
		return bytes;
	}

	/**
	 * �õ��ļ�����
	 * 0-txt
	 * 1-jpg
	 * 2-avi
	 * 3-gif
	 * @param srcPath
	 * @return
	 */
	private int getFileType(String srcPath) {
		String ext = srcPath.substring(srcPath.lastIndexOf(".")).toLowerCase();
		if(".txt".equals(ext)){
			return 0;
		}
		else if(".jpg".equals(ext)){
			return 1;
		}
		else if(".avi".equals(ext)){
			return 2;
		}
		else if(".gif".equals(ext)){
			return 3;
		}
		else if(".yar".equals(ext)){
			return 4;
		}
		return -1;
	}
	/**
	 * �������ļ���yar�鵵�ļ���
	 * @param srcPath
	 * @param yarPath
	 */
	public void appendFile(String srcPath,String yarPath){
		FileOutputStream fout;
		try {
			fout = new FileOutputStream(yarPath,true);
			appendFile(srcPath,fout);
			fout.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	/**
	 * �⵵
	 * @param yarPath
	 * @param destPath
	 */
	public void unarchive(String yarPath,String destPath){
		try {
			FileInputStream fin = new FileInputStream(yarPath);
			// ѭ����ȡ��һ���ļ�
			int i=1;
			while(readNextFile(destPath,i+"",fin)){
				i++;
			}
			;
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * ��ȡ��һ���ļ�
	 * @param fin
	 * @return
	 */
	private boolean readNextFile(String destPath,String fname,FileInputStream fin) {
		try {
			//1. �õ��ļ���չ��
			int type = fin.read();
			// ����ļ�����ĩβ
			if(type==-1){
				return false;
			}
			String ext = getFileExt(type);
			
			/**
			 * ��ʼ��ȡ�ļ�
			 */
			// ���ļ������
			FileOutputStream fout = new FileOutputStream(destPath+"/"+fname+ext);
			
			//2. ��ȡ�ļ�����
			byte[] bytes = new byte[4];
			fin.read(bytes);
			//ת���ֽ�����Ϊint
			int fileLength = byteArr2Int(bytes);
			
			//3.��ȡ�ļ���д�����ļ�
			byte[] buffer = new byte[1024];
			// �����ȡ�ļ��Ĵ���
			int count = 0;
			if(fileLength % buffer.length==0){
				count = fileLength / buffer.length;
			}
			else{
				count = fileLength / buffer.length+1;
			}
			// ��ʼѭ����ȡ��д��
			for(int i=0;i<count;i++){
				// �������һ��
				if(i!=(count-1)){
					fin.read(buffer);
					fout.write(buffer);
				}
				else{
					byte[] buf0 = new byte[fileLength % buffer.length];
					fin.read(buf0);
					fout.write(buf0);
				}
			}
			fout.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return true;
	}
	/**
	 * ������Ϊ4���ֽ�����ת��Ϊint
	 * ת����ʽ��int2arrҪһ��
	 * @param bytes
	 * @return
	 */
	private int byteArr2Int(byte[] bytes) {
		return (bytes[0] & 0xFF) | (bytes[1] & 0xFF) << 8 | (bytes[2] & 0xFF) << 16 | (bytes[3] & 0xFF) << 24;
	}
	
	private String getFileExt(int type) {
		String ext = ".tmp";
		switch(type){
			case 0:
				ext = ".txt";
				break;
			case 1:
				ext = ".jpg";
				break;
			case 2:
				ext = ".avi";
				break;
			case 3:
				ext = ".gif";
				break;
			case 4:
				ext = ".yar";
				break;
			default:
				ext = ".tmp";
				break;
		}
		return ext;
	}
}