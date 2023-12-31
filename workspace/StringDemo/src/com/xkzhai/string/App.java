package com.xkzhai.string;

import java.nio.charset.Charset;

public class App {
	public static void main(String[] args){
		
		String str1 = "abc"; // "abc"存储于String池，产生1个对象
		
		String str2 = new String("abc");// 开辟了内存空间, 产生2个对象
				
		// 1. String 长度，表字符个数
		String str3 = "hello 中国 中国";
		System.out.println(str3.length());
		
		// 2. 提取指定位置上的字符
		System.out.println(str3.charAt(1));
		System.out.println("-------");
		for(int i=0;i<str3.length();i++){
			System.out.println(str3.charAt(i));
		}
		
		// 3. 复制String 中的字符，产生新的数组，不会影响原来的数组
		char[] arr = str3.toCharArray();
		
		// 4. 返回子串在母串中的位置(索引值以0为基址)
		int pos = str3.indexOf("中国");
		System.out.println(pos);
		// 7指定开始搜索的位置
		pos = str3.indexOf("中国",7);
		System.out.println(pos);
		
		// 5. 判断是否以指定字符结尾/开始
		String s1 = "3Month";
		//s1 = null;
		String s2 = "3Year";
		String s3 = "3Day";
		System.out.println(s1.endsWith("Year"));
		System.out.println(s1.startsWith("3"));
		
		// 6. 字符串分割，形成String数组
		String str = "hello,,,,world,";
		String[] strArr = str.split(",");
		System.out.println(strArr.length);
		
		// 7. subString 子串
		// beginIndex: int
		// endIndex: int
		// 前包后不包
		str = "hello,world";
		System.out.println(str.substring(6,10));
		System.out.println(str.substring(0,str.length()));
		
		// 8. 字符集编码
		System.out.println("---------------");
		char a = 97;
		System.out.println(a);
		a = 'a';
		System.out.println(a);
		// unicode编码，2个字节存储
		a = '\u0061';
		a = 0x0061;
		System.out.println(a);
		
		/*
		// 打印所有unicode字符集
		// 需修改工作空间编码方式
		int col = 0;
		for(int i=0;i<=0xffff;i++){
			System.out.print((char)i);
			col++;
			if(col>=80){
				col = 0;
				System.out.println();
			}
		}
		*/
		
		str = "ab中c"; // 中文字节数取决于工作空间编码方式
		byte[] bytes = str.getBytes();
		System.out.println(bytes);
		
		System.out.println(Charset.defaultCharset().name());
		
		
		
	}
}
