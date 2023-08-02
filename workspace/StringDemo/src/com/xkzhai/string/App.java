package com.xkzhai.string;

import java.nio.charset.Charset;

public class App {
	public static void main(String[] args){
		
		String str1 = "abc"; // "abc"�洢��String�أ�����1������
		
		String str2 = new String("abc");// �������ڴ�ռ�, ����2������
				
		// 1. String ���ȣ����ַ�����
		String str3 = "hello �й� �й�";
		System.out.println(str3.length());
		
		// 2. ��ȡָ��λ���ϵ��ַ�
		System.out.println(str3.charAt(1));
		System.out.println("-------");
		for(int i=0;i<str3.length();i++){
			System.out.println(str3.charAt(i));
		}
		
		// 3. ����String �е��ַ��������µ����飬����Ӱ��ԭ��������
		char[] arr = str3.toCharArray();
		
		// 4. �����Ӵ���ĸ���е�λ��(����ֵ��0Ϊ��ַ)
		int pos = str3.indexOf("�й�");
		System.out.println(pos);
		// 7ָ����ʼ������λ��
		pos = str3.indexOf("�й�",7);
		System.out.println(pos);
		
		// 5. �ж��Ƿ���ָ���ַ���β/��ʼ
		String s1 = "3Month";
		//s1 = null;
		String s2 = "3Year";
		String s3 = "3Day";
		System.out.println(s1.endsWith("Year"));
		System.out.println(s1.startsWith("3"));
		
		// 6. �ַ����ָ�γ�String����
		String str = "hello,,,,world,";
		String[] strArr = str.split(",");
		System.out.println(strArr.length);
		
		// 7. subString �Ӵ�
		// beginIndex: int
		// endIndex: int
		// ǰ���󲻰�
		str = "hello,world";
		System.out.println(str.substring(6,10));
		System.out.println(str.substring(0,str.length()));
		
		// 8. �ַ�������
		System.out.println("---------------");
		char a = 97;
		System.out.println(a);
		a = 'a';
		System.out.println(a);
		// unicode���룬2���ֽڴ洢
		a = '\u0061';
		a = 0x0061;
		System.out.println(a);
		
		/*
		// ��ӡ����unicode�ַ���
		// ���޸Ĺ����ռ���뷽ʽ
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
		
		str = "ab��c"; // �����ֽ���ȡ���ڹ����ռ���뷽ʽ
		byte[] bytes = str.getBytes();
		System.out.println(bytes);
		
		System.out.println(Charset.defaultCharset().name());
		
		
		
	}
}