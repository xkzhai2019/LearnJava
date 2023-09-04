package com.xkzhai.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import org.junit.Test;

public class CopyDir {
	public static void main(String[] args) {
		copyDir(new File("./a"),new File("./b"));
		System.out.println("over");
	}
	/**
	 * ����Ŀ¼
	 */
	public static void copyDir(File src,File dest){
		// Դ�ļ��Ƿ����
		if(src.exists()){
			// Դ�ļ���Ŀ¼
			if(src.isDirectory()){
				// ��dest�´���ͬ����Ŀ¼
				File dir = new File(dest,src.getName());
				dir.mkdirs();
				File[] files = src.listFiles();
				for(File f: files){
					copyDir(f,dir);
				}
			}
			// Դ�ļ����ļ�
			else{
				copyFile(src,dest);
			}
		}
	}
	
//	/**
//	 * ����Ŀ¼
//	 */
//	private void copyDir(String srcPath, String destPath){
//		// ԴĿ¼
//		File srcFile = new File(srcPath);
//		// Ŀ��Ŀ¼
//		File destFile = new File(destPath);
//
//		// Դ�ļ��Ƿ����
//		if(srcFile.exists()){
//			// ԭ�ļ��Ƿ���Ŀ¼
//			if(srcFile.isDirectory()){
//				
//			}
//			// �ļ�
//			else{
//				// ����·��
//				String abPath = srcFile.getAbsolutePath();
//				abPath.substring(srcPath.length());
//			}
//		}
//	}

	/**
	 * �����ļ�
	 */
	private static void copyFile(File srcFile,File destDir){
		try {
			if(!destDir.exists()){
				destDir.mkdirs();
			}
			// Դ�ļ�
			FileInputStream fin = new FileInputStream(srcFile);
			
			// Ŀ���ļ�
			File destFile = new File(destDir,srcFile.getName());
			FileOutputStream fout = new FileOutputStream(destFile);
			
			// �ļ��Կ�
			int len = -1;
			byte[] buffer = new byte[1024];
			while((len=fin.read(buffer))!=-1){
				fout.write(buffer,0,len);
			}
			fin.close();
			fout.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
//	@Test
//	public void testCopyFile(){
//		copyFile("hello.txt","C:\\LearnJava");
//		System.out.println("over");
//	}
	
//	/**
//	 * �����ļ�
//	 * @param srcFile
//	 * @param destDir
//	 */
//	private void copyFile(String srcFileStr,String destDirStr){
//		try {
//			// Դ�ļ�����
//			File srcFile = new File(srcFileStr);
//			FileInputStream fin = new FileInputStream(srcFile);
//			
//			// Ŀ���ļ�
//			File destFile = new File(destDirStr,srcFile.getName());
//			FileOutputStream fout = new FileOutputStream(destFile);
//			int len = -1;
//			byte[] buffer = new byte[1024];
//			while((len=fin.read(buffer))!=-1){
//				fout.write(buffer, 0, len);
//			}
//			fout.close();
//			fin.close();
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}
//	
//	/**
//	 * �����ļ�
//	 * @param srcFile
//	 * @param destFile
//	 */
//	private void copyFile(File srcFile,File destFile){
//		copyFile(srcFile.getAbsoluteFile(),destFile.getAbsoluteFile())
//	}
}