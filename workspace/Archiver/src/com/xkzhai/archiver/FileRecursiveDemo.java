package com.xkzhai.archiver;

import java.io.File;
import java.util.List;

import org.junit.Test;

public class FileRecursiveDemo {
	public static void main(String[] args) {
		showFile("C:\\LearnJava");
	}
	
	
	/**
	 * 显示（文件+文件夹）路径名
	 */
	private static void showFile(String path){
		// 通过路径构造file对象
		File f = new File(path);
		if(f.exists()){
			// 输出文件绝对路径
			System.out.println(f.getAbsolutePath());
			// 是否是目录
			if(f.isDirectory()){
				File[] children  = f.listFiles();
				if(children ==null || children.length == 0){
					System.out.println(f.getAbsolutePath()+"是空文件夹");
					return;
				}
				for(File ff: children){
					String p0 = ff.getAbsolutePath();
					showFile(p0);
				}
			}
//			// 是否是文件
//			if(f.isFile()){
//				System.out.println(f.getAbsolutePath());
//			}
		}
	}
	/**
	 * 测试null是否会导致空指针异常
	 */
	@Test
	public void test(){
		List<String> list = null;
		String[] ss = null;
		for(String s: ss){
			System.out.println(s);
		}
	}
}
