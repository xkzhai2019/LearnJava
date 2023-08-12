package com.xkzhai.archiver;

import org.junit.Test;

public class App {

	/**
	 * 新建归档文件
	 */
	@Test
	public void newArchiverFile(){
		String path = "home/xkzhai/hello.txt";
		System.out.println(path.substring(path.lastIndexOf(".")));
		
		Archiver archiver = new Archiver();
		String[] srcPaths = {
				"1.jpg",
				"hello.txt"
		};
		String yarPath = "myyar.yar";
		archiver.newArachiverFile(srcPaths, yarPath);
		System.out.println("over");
	}
	
	/**
	 * 向原有归档文件中添加新文件
	 */
	@Test
	public void addFile(){
		Archiver archiver = new Archiver();
		archiver.addFile("hello_copy.txt", "myyar.yar");
		System.out.println("over");
	}

}
