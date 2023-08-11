package com.xkzhai.collection;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

/**
 * MapǶ��
 * */
public class MapNestedDemo {

	public static void main(String[] args) {
		//1. �༶������(String)���� ��ÿ��5��
		Map<String, String> names = null;
				
		//2. �꼶���༶���ϣ�ÿ���꼶2����
		Map<String,Map<String, String>> grade = null;
				
		//3. ѧУ���꼶���ϣ�3���꼶
		// ����ѧУ�����꼶�ļ���
		Map<String,Map<String,Map<String, String>>> school = new HashMap<String,Map<String,Map<String, String>>>();
		int no = 0;
		for(int i=1;i<=3;i++){
			grade = new HashMap<String,Map<String, String>>();
			for(int j=1;j<=2;j++){
				names = new HashMap<String,String>();
				for(int k=1;k<=5;k++){
					names.put("No"+k,"tom-"+(no++));
				}
				grade.put(j+"��",names);
			}
			school.put(i+"�꼶",grade);
		}
		//outSchool(school);
		System.out.println("-------------");
		outSchool2(school);
	}
	
	public static void outSchool(Map<String,Map<String,Map<String, String>>> school ){
		// 1. �꼶��ɵ�ѧУ����
		Set<Entry<String,Map<String,Map<String, String>>>> gradeEntrys = school.entrySet();
		for(Entry<String,Map<String,Map<String, String>>> gradeEntry : gradeEntrys){
			// �꼶����
			String gradeKey = gradeEntry.getKey();
			// ����꼶����
			System.out.println(gradeKey);
			System.out.println("------------");
			
			// 2. �༶��ɵ��꼶����
			Map<String,Map<String, String>> classes = gradeEntry.getValue();
			Set<Entry<String,Map<String,String>>> classEntrys = classes.entrySet();
			
			for(Entry<String,Map<String,String>> classEntry: classEntrys){
				// �༶����
				String classKey = classEntry.getKey();
				System.out.println("\t"+classKey);
				// 3. ������ɵİ༶����
				Map<String, String> names = classEntry.getValue();
				Set<Entry<String,String>> nameEntrys = names.entrySet();
				
				for(Entry<String,String> nameEntry: nameEntrys){
					// ѧ��
					String no = nameEntry.getKey();
					String name = nameEntry.getValue();
					System.out.println("\t"+"\t"+gradeKey+"-"+classKey+"-"+no+":"+name);
				}
			}
		}
	}
	
	// ������
	public static void outSchool2(Map<String,Map<String,Map<String, String>>> school ){
		Iterator<Entry<String,Map<String,Map<String, String>>>> it1 = school.entrySet().iterator();
		while(it1.hasNext()){
			Entry<String,Map<String,Map<String, String>>> entry = it1.next();
			String k1 = entry.getKey();
			Map<String,Map<String, String>> v1 = entry.getValue();
			System.out.println(k1);
			
			Iterator<Entry<String,Map<String, String>>> it2 = v1.entrySet().iterator();
			while(it2.hasNext()){
				Entry<String,Map<String, String>> e2 = it2.next();
				String k2 = e2.getKey();
				Map<String, String> v2 = e2.getValue();
				System.out.println("\t"+k2);
				Iterator<Entry<String, String>> it3 = v2.entrySet().iterator();
				while(it3.hasNext()){
					Entry<String, String> e3 = it3.next();
					String k3 = e3.getKey();
					String v3 = e3.getValue();
					System.out.println("\t"+"\t"+k3+v3);
				}
			}
		}
	}
}