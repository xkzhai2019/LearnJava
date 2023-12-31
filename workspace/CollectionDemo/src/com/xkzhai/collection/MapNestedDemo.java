package com.xkzhai.collection;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

/**
 * Map嵌套
 * */
public class MapNestedDemo {

	public static void main(String[] args) {
		//1. 班级：名单(String)集合 ，每班5人
		Map<String, String> names = null;
				
		//2. 年级：班级集合，每个年级2个班
		Map<String,Map<String, String>> grade = null;
				
		//3. 学校：年级集合，3个年级
		// 创建学校，是年级的集合
		Map<String,Map<String,Map<String, String>>> school = new HashMap<String,Map<String,Map<String, String>>>();
		int no = 0;
		for(int i=1;i<=3;i++){
			grade = new HashMap<String,Map<String, String>>();
			for(int j=1;j<=2;j++){
				names = new HashMap<String,String>();
				for(int k=1;k<=5;k++){
					names.put("No"+k,"tom-"+(no++));
				}
				grade.put(j+"班",names);
			}
			school.put(i+"年级",grade);
		}
		//outSchool(school);
		System.out.println("-------------");
		outSchool2(school);
	}
	
	public static void outSchool(Map<String,Map<String,Map<String, String>>> school ){
		// 1. 年级组成的学校集合
		Set<Entry<String,Map<String,Map<String, String>>>> gradeEntrys = school.entrySet();
		for(Entry<String,Map<String,Map<String, String>>> gradeEntry : gradeEntrys){
			// 年级号码
			String gradeKey = gradeEntry.getKey();
			// 输出年级名称
			System.out.println(gradeKey);
			System.out.println("------------");
			
			// 2. 班级组成的年级集合
			Map<String,Map<String, String>> classes = gradeEntry.getValue();
			Set<Entry<String,Map<String,String>>> classEntrys = classes.entrySet();
			
			for(Entry<String,Map<String,String>> classEntry: classEntrys){
				// 班级号码
				String classKey = classEntry.getKey();
				System.out.println("\t"+classKey);
				// 3. 名单组成的班级集合
				Map<String, String> names = classEntry.getValue();
				Set<Entry<String,String>> nameEntrys = names.entrySet();
				
				for(Entry<String,String> nameEntry: nameEntrys){
					// 学号
					String no = nameEntry.getKey();
					String name = nameEntry.getValue();
					System.out.println("\t"+"\t"+gradeKey+"-"+classKey+"-"+no+":"+name);
				}
			}
		}
	}
	
	// 迭代器
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
