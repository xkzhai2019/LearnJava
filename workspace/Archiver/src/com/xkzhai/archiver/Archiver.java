package com.xkzhai.archiver;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Archiver {
	/**
	 * 创建归档文件
	 */
	public void newArachiverFile(String[] srcPaths,String yarPath){
		FileOutputStream fout = null;
		try {
			fout = new FileOutputStream(yarPath);
			for(String srcPath: srcPaths){
				// 向yar归档文件中添加文件
				addFile(srcPath,fout);
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
	 * 向yar归档文件中添加文件
	 * @param srcPath
	 * @param fout
	 * @throws Exception 
	 */
	private void addFile(String srcPath, FileOutputStream fout){
		FileInputStream fin = null;
		try {
			//1. 取出srcPath文件类型
			int fType = getFileType(srcPath);
			
			//2. 取出srcPath文件长度
			fin = new FileInputStream(srcPath);
			int length = fin.available();
			
			//3. 将fType写入fout
			byte bFtype = (byte)fType;
			fout.write(new byte[]{bFtype});
			
			//4. 将长度写入fout
			byte[] bytes = int2byteArr(length);
			fout.write(bytes);
			
			//5. 写入文件内容
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
	 * 将整数转换为字节数组
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
	 * 得到文件类型
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
		return -1;
	}
	/**
	 * 添加新文件到yar归档文件中
	 * @param srcPath
	 * @param yarPath
	 */
	public void addFile(String srcPath,String yarPath){
		FileOutputStream fout;
		try {
			fout = new FileOutputStream(yarPath,true);
			addFile(srcPath,fout);
			fout.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
