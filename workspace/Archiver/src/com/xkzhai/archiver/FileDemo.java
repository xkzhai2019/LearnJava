package com.xkzhai.archiver;

import java.io.File;

import org.junit.Test;

public class FileDemo {
	@Test
	public void file1(){
		//File f = new File("..\\\\Archiver\\\\hello.txt");
		File f = new File("..\\\\Archiver");
		
		System.out.println(f.exists());
		System.out.println(f.isDirectory());
		
		f = new File("./a/b/c");
		if(!f.exists()){
			f.mkdirs();
		}
		
		f = new File("..\\\\Archiver");
		if(f.isDirectory()){
			File[] files = f.listFiles();
			for(File f0:files){
				System.out.println(f0.getAbsolutePath());
				//System.out.println(f0.getName());
			}
		}
	}
}
