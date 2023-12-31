package com.xkzhai.string;

public class App2 {
	public static void main(String[] args) throws Exception{
		
		String s1 = "a中b";
		String s2 = "def";
		String str = s1 + s2;
		
		// 编码
		byte[] bytes = str.getBytes("GBK");
		
		System.out.println(bytes.length);
		
		// 解码，格式要一致
		String str2 = new String(bytes,"ISO-8859-1");
		System.out.println(str2);
		str2 = new String(bytes,"GBK");
		System.out.println(str2);
		
		//ISO字符编码，无法识别中文字符 
		bytes = str.getBytes("ISO-8859-1");
		String str3 = new String(bytes,"ISO-8859-1");
		System.out.println(str3);
		str3 = new String(bytes,"GBK");
		System.out.println(str3);
		
		// homework1：找出姓名在unicode中对应的值
		str = "王小二";
		bytes = str.getBytes("unicode");
		System.out.println(bytes[2]);
		char[] arr = {'0','1','2','3','4','5','6','7','8','9','a','b','c','d','e','f'};
		int a = '王';
		System.out.println("0x"+arr[(a>>12)&0xf]+arr[(a>>8)&0xf]+arr[(a>>4)&0xf]+arr[a&0xf]);
		
		// homework2：substring
		String s = "abc";
		System.out.println(StringUtil.subString(s, 0, 3));
	}
}
