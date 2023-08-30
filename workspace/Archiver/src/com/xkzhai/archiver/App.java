package com.xkzhai.archiver;

import org.junit.Test;

public class App {

	/**
	 * �½��鵵�ļ�
	 */
	@Test
	public void newArchiverFile(){
		String path = "home/xkzhai/hello.txt";
		System.out.println(path.substring(path.lastIndexOf(".")));
		
		Archiver archiver = new Archiver();
		String[] srcPaths = {
				"1.jpg",
				"hello.txt",
				"myyar.yar"
		};
		String yarPath = "newyar.yar";
		archiver.newArachiverFile(srcPaths, yarPath);
		System.out.println("over");
	}
	
	/**
	 * ��ԭ�й鵵�ļ����������ļ�
	 */
	@Test
	public void addFile(){
		Archiver archiver = new Archiver();
		archiver.appendFile("hello_copy.txt", "myyar.yar");
		System.out.println("over");
	}
	
	/**
	 * �⵵yar�ļ�
	 */
	@Test
	public void unarchiveFile(){
		Archiver archiver = new Archiver();
		archiver.unarchive("unarch/3.yar", "unarch/tmp");
		System.out.println("over");
	}

}