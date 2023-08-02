package com.xkzhai.collection;

public class StringEqualsDemo {

	public static void main(String[] args) {
		String s1 = "abc";
		String s2 = "abc";
		String s3 = new String("abc");
		String s4 = new String("abc");
		
		System.out.println(s1==s2);
		// == 判断对象的内存地址是否相同，不是对象的内容
		System.out.println(s3==s4);
		
		// equals方法判断对象的内容是否相同
		System.out.println(s3.equals(s4));

	}

}
