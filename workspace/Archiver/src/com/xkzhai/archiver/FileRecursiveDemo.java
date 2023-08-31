package com.xkzhai.archiver;

import java.io.File;
import java.util.List;

import org.junit.Test;

public class FileRecursiveDemo {
	public static void main(String[] args) {
		showFile("C:\\LearnJava");
	}
	
	
	/**
	 * ��ʾ���ļ�+�ļ��У�·����
	 */
	private static void showFile(String path){
		// ͨ��·������file����
		File f = new File(path);
		if(f.exists()){
			// ����ļ�����·��
			System.out.println(f.getAbsolutePath());
			// �Ƿ���Ŀ¼
			if(f.isDirectory()){
				File[] children  = f.listFiles();
				if(children ==null || children.length == 0){
					System.out.println(f.getAbsolutePath()+"�ǿ��ļ���");
					return;
				}
				for(File ff: children){
					String p0 = ff.getAbsolutePath();
					showFile(p0);
				}
			}
//			// �Ƿ����ļ�
//			if(f.isFile()){
//				System.out.println(f.getAbsolutePath());
//			}
		}
	}
	/**
	 * ����null�Ƿ�ᵼ�¿�ָ���쳣
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
