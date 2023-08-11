package com.xkzhai.collection;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/*
 * ����Ƕ��
 * */
public class ListNestedDemo {

	public static void main(String[] args) {
		//1. �༶������(String)���� ��ÿ��10��
		List<String> names = null;
		
		//2. �꼶���༶���ϣ�ÿ���꼶10����
		List<List<String>> grade = null;
		
		//3. ѧУ���꼶���ϣ�6���꼶
		// ����ѧУ�����꼶�ļ���
		List<List<List<String>>> school = new ArrayList<List<List<String>>>();
		// 6���꼶
		for(int i=1;i<=6;i++){
			// �����꼶���ǰ༶����
			grade = new ArrayList<List<String>>();
			// ����ÿ���꼶�İ༶����
			for(int j=1;j<=10;j++){
				//�����༶������������
				names = new ArrayList<String>();
				for(int k=1;k<=10;k++){
					names.add("tom-"+i+"-"+j+"-"+k);
				}
				grade.add(names);
			}
			school.add(grade);
		}
		outNames2(school);
	}
	
	public static void outNames(List<List<List<String>>> school){
		for(int i=0;i<school.size();i++){
			// ȡ�õ�ǰ�꼶����
			System.out.println("��"+i+"�꼶");
			List<List<String>> grade = school.get(i);
			for(int j=0;j< grade.size();j++){
				// ȡ�õ�ǰ�༶
				System.out.println("��"+j+"�༶");
				List<String> names = grade.get(j);
				for(int k=0;k<names.size();k++){
					System.out.println(names.get(k));
				}
			}
		}
	}
	/*
	 * ʹ�õ��������
	 * */
	public static void outNames2(List<List<List<String>>> school){
		Iterator<List<List<String>>> it = school.iterator();
		while(it.hasNext()){
			// 1.ȡ��ÿ���꼶
			List<List<String>> grade = it.next();
			Iterator<List<String>> classesit = grade.iterator();
			while(classesit.hasNext()){
				// 2.ȡ��ÿ���༶
				List<String> names = classesit.next();
				Iterator<String> namesit = names.iterator();
				
				while(namesit.hasNext()){
					System.out.println(namesit.next());
				}
			}
		}
	}
}