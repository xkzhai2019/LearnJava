package com.xkzhai.string;

public class WrapperDemo {
	// ctrl + shift + f ��ʽ������
	// alt + / ���ݸ���
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
		
		//�ַ���ת����
		Integer i0 = Integer.parseInt("123");	
		System.out.println(i0);
		
		
		// ��װ�಻��ֱ�Ӳ�������
		// jdk1.5�󣬿����Զ�����װ��
		Integer i1 = new Integer(1);
		Integer i2 = new Integer(2);
		System.out.println(i1.intValue()+i2.intValue());
		System.out.println(i1+i2);
		
//		Integer i100 = 100;
//		for(int j=0;j<i100;j++){
//			
//		}

		
		// �������Ͳ��Ƕ����޷�����null�ĸ���
		// �������Ϳ���ֱ�Ӳ�������
		//int i2 = null;
		
		Integer itmp = null;
		// System.out.println(itmp+100); // �粻�ж�null���п��ܷ�����ָ���쳣
		System.out.println(itmp==null? 0:itmp+100);
		
	}
}