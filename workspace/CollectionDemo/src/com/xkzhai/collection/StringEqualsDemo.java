package com.xkzhai.collection;

public class StringEqualsDemo {

	public static void main(String[] args) {
		String s1 = "abc";
		String s2 = "abc";
		String s3 = new String("abc");
		String s4 = new String("abc");
		
		System.out.println(s1==s2);
		// == �ж϶�����ڴ��ַ�Ƿ���ͬ�����Ƕ��������
		System.out.println(s3==s4);
		
		// equals�����ж϶���������Ƿ���ͬ
		System.out.println(s3.equals(s4));

	}

}