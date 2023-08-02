package com.xkzhai.string;

public class StringBuildDemo {

	public static void main(String[] args) {
//		Person p = new Person();
//		p.setName("xkzhai");
//		p.setAge(10);
		
		
		// builder模式
		// 方法链编程
		Person p = new Person()
		.setName("xkzhai")
		.setAge(10)
		.setSex(true);
	}

}
