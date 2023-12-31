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
	 * 拷贝目录
	 */
	public static void copyDir(File src,File dest){
		// 源文件是否存在
		if(src.exists()){
			// 源文件是目录
			if(src.isDirectory()){
				// 在dest下创建同名子目录
				File dir = new File(dest,src.getName());
				dir.mkdirs();
				File[] files = src.listFiles();
				for(File f: files){
					copyDir(f,dir);
				}
			}
			// 源文件是文件
			else{
				copyFile(src,dest);
			}
		}
	}
	
//	/**
//	 * 拷贝目录
//	 */
//	private void copyDir(String srcPath, String destPath){
//		// 源目录
//		File srcFile = new File(srcPath);
//		// 目标目录
//		File destFile = new File(destPath);
//
//		// 源文件是否存在
//		if(srcFile.exists()){
//			// 原文件是否是目录
//			if(srcFile.isDirectory()){
//				
//			}
//			// 文件
//			else{
//				// 绝对路径
//				String abPath = srcFile.getAbsolutePath();
//				abPath.substring(srcPath.length());
//			}
//		}
//	}

	/**
	 * 复制文件
	 */
	private static void copyFile(File srcFile,File destDir){
		try {
			if(!destDir.exists()){
				destDir.mkdirs();
			}
			// 源文件
			FileInputStream fin = new FileInputStream(srcFile);
			
			// 目标文件
			File destFile = new File(destDir,srcFile.getName());
			FileOutputStream fout = new FileOutputStream(destFile);
			
			// 文件对拷
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
//	 * 复制文件
//	 * @param srcFile
//	 * @param destDir
//	 */
//	private void copyFile(String srcFileStr,String destDirStr){
//		try {
//			// 源文件对象
//			File srcFile = new File(srcFileStr);
//			FileInputStream fin = new FileInputStream(srcFile);
//			
//			// 目标文件
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
//	 * 复制文件
//	 * @param srcFile
//	 * @param destFile
//	 */
//	private void copyFile(File srcFile,File destFile){
//		copyFile(srcFile.getAbsoluteFile(),destFile.getAbsoluteFile())
//	}
}
