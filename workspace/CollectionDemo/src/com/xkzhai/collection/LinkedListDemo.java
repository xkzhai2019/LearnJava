package com.xkzhai.collection;

import java.util.LinkedList;
import java.util.List;

public class LinkedListDemo {

	public static void main(String[] args) {
		// ����
		// ͨ��������ʵ�ֶ�������
		// �洢�ٶȿ죬��ѯ��
		List<String> list = new LinkedList<String>();
		list.add("tom");
		list.add(0,"alice");
		list.add("bob");
		
		for(int i=0;i<list.size();i++){
			System.out.println(list.get(i));
		}
		
	}

}