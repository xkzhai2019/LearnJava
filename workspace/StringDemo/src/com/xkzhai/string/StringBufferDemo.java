package com.xkzhai.string;

public class StringBufferDemo {

	public static void main(String[] args) {
		StringBuffer buffer = new StringBuffer();
		buffer.append("abc");
		System.out.println(buffer);
		
		for(int i=0;i<=100;i++){
			buffer.append(i);
		}	
		System.out.println(buffer);
		System.out.println("over");
		
		System.out.println(buffer.charAt(4));
		
		buffer.delete(4, 6); // 前包后不包
		System.out.println(buffer);
		
		// offset: 偏移量，代表前面空出多少格
		buffer.insert(0, "insert");
		System.out.println(buffer); 
		
		System.out.println(buffer.substring(0, 6));
		
		System.out.println(buffer.reverse());
	}

}
