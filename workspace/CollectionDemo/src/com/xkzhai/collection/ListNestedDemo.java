package com.xkzhai.collection;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/*
 * 集合嵌套
 * */
public class ListNestedDemo {

	public static void main(String[] args) {
		//1. 班级：名单(String)集合 ，每班10人
		List<String> names = null;
		
		//2. 年级：班级集合，每个年级10个班
		List<List<String>> grade = null;
		
		//3. 学校：年级集合，6个年级
		// 创建学校，是年级的集合
		List<List<List<String>>> school = new ArrayList<List<List<String>>>();
		// 6个年级
		for(int i=1;i<=6;i++){
			// 创建年级，是班级集合
			grade = new ArrayList<List<String>>();
			// 处理每个年级的班级集合
			for(int j=1;j<=10;j++){
				//创建班级，是名单集合
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
			// 取得当前年级集合
			System.out.println("第"+i+"年级");
			List<List<String>> grade = school.get(i);
			for(int j=0;j< grade.size();j++){
				// 取得当前班级
				System.out.println("第"+j+"班级");
				List<String> names = grade.get(j);
				for(int k=0;k<names.size();k++){
					System.out.println(names.get(k));
				}
			}
		}
	}
	/*
	 * 使用迭代器输出
	 * */
	public static void outNames2(List<List<List<String>>> school){
		Iterator<List<List<String>>> it = school.iterator();
		while(it.hasNext()){
			// 1.取出每个年级
			List<List<String>> grade = it.next();
			Iterator<List<String>> classesit = grade.iterator();
			while(classesit.hasNext()){
				// 2.取出每个班级
				List<String> names = classesit.next();
				Iterator<String> namesit = names.iterator();
				
				while(namesit.hasNext()){
					System.out.println(namesit.next());
				}
			}
		}
	}
}
