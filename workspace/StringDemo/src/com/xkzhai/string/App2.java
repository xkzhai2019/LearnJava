package com.xkzhai.string;

public class App2 {
	public static void main(String[] args) throws Exception{
		
		String s1 = "a��b";
		String s2 = "def";
		String str = s1 + s2;
		
		// ����
		byte[] bytes = str.getBytes("GBK");
		
		System.out.println(bytes.length);
		
		// ���룬��ʽҪһ��
		String str2 = new String(bytes,"ISO-8859-1");
		System.out.println(str2);
		str2 = new String(bytes,"GBK");
		System.out.println(str2);
		
		//ISO�ַ����룬�޷�ʶ�������ַ� 
		bytes = str.getBytes("ISO-8859-1");
		String str3 = new String(bytes,"ISO-8859-1");
		System.out.println(str3);
		str3 = new String(bytes,"GBK");
		System.out.println(str3);
		
		// homework1���ҳ�������unicode�ж�Ӧ��ֵ
		str = "��С��";
		bytes = str.getBytes("unicode");
		System.out.println(bytes[2]);
		char[] arr = {'0','1','2','3','4','5','6','7','8','9','a','b','c','d','e','f'};
		int a = '��';
		System.out.println("0x"+arr[(a>>12)&0xf]+arr[(a>>8)&0xf]+arr[(a>>4)&0xf]+arr[a&0xf]);
		
		// homework2��substring
		String s = "abc";
		System.out.println(StringUtil.subString(s, 0, 3));
	}
}