package com.xkzhai.string;

public class App3 {
	public static void main(String[] args) throws Exception{
		
		// utf-8：國 --> -27 -100 -117 使用3个字节存储
		String str = "a國b";
		byte[] bytes = str.getBytes("utf-8");
		System.out.println(bytes);
		
		// gbk: 中 --> -121 -8使用2个字节存储
		bytes = str.getBytes("GBK");
		System.out.println(bytes);
		
		// ISO8859-1：國 --> 63不识别
		bytes = str.getBytes("ISO8859-1");
		System.out.println(bytes);
		
		// big-5：國 --> -80 -22
		bytes = str.getBytes("big5");
		System.out.println(bytes);
		byte[] big5 = {-80,-22};
		// new String(byte[], Charset)
		// 通过字符集对byte[] 进行解码decode，转变为字符串
		System.out.println(new String(big5,"big5")); 
		
	}
}
