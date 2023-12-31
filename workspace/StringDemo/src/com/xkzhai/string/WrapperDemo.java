package com.xkzhai.string;

public class WrapperDemo {
	// ctrl + shift + f 格式化代码
	// alt + / 内容辅助
	public static void main(String[] args) {
		Byte b = new Byte((byte)12);
		System.out.println(Byte.MAX_VALUE);
		System.out.println(Byte.MIN_VALUE);
		
		Integer.toHexString(100);
		
		Short s = new Short((short)127);
		Integer i = new Integer(127);
		Long l = new Long(127);
		
		Boolean bb = new Boolean(true);
		bb.booleanValue();
		
		Float f = new Float(12.5f);
		Double d = new Double("12.5");
		Character c = new Character('A');
		
		//字符串转整数
		Integer i0 = Integer.parseInt("123");	
		System.out.println(i0);
		
		
		// 包装类不能直接参与运算
		// jdk1.5后，可以自动拆箱装箱
		Integer i1 = new Integer(1);
		Integer i2 = new Integer(2);
		System.out.println(i1.intValue()+i2.intValue());
		System.out.println(i1+i2);
		
//		Integer i100 = 100;
//		for(int j=0;j<i100;j++){
//			
//		}

		
		// 基本类型不是对象，无法表达null的概念
		// 基本类型可以直接参与运算
		//int i2 = null;
		
		Integer itmp = null;
		// System.out.println(itmp+100); // 如不判断null，有可能发生空指针异常
		System.out.println(itmp==null? 0:itmp+100);
		
	}
}
