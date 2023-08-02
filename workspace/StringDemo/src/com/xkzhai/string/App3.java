package com.xkzhai.string;

public class App3 {
	public static void main(String[] args) throws Exception{
		
		// utf-8���� --> -27 -100 -117 ʹ��3���ֽڴ洢
		String str = "a��b";
		byte[] bytes = str.getBytes("utf-8");
		System.out.println(bytes);
		
		// gbk: �� --> -121 -8ʹ��2���ֽڴ洢
		bytes = str.getBytes("GBK");
		System.out.println(bytes);
		
		// ISO8859-1���� --> 63��ʶ��
		bytes = str.getBytes("ISO8859-1");
		System.out.println(bytes);
		
		// big-5���� --> -80 -22
		bytes = str.getBytes("big5");
		System.out.println(bytes);
		byte[] big5 = {-80,-22};
		// new String(byte[], Charset)
		// ͨ���ַ�����byte[] ���н���decode��ת��Ϊ�ַ���
		System.out.println(new String(big5,"big5")); 
		
	}
}