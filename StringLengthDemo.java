/*
	�ַ�������
*/
class StringLengthDemo{
	public static void main(String[] args){
		String sys = "ѧ����Ϣ����";
		System.out.println("��ӭʹ�á�"+sys+"��ϵͳ");
		System.out.println("������һ������Ա���룺");
		java.util.Scanner input = new java.util.Scanner(System.in);
		String pass = input.next();

		int length = pass.length();

		if(length>6 && length<12){
			System.out.println("���볤�ȷ��Ϲ涨");
			System.out.println("����Ч�����μ����룺"+pass);
		}else if(length>=12){
			System.out.println("�������");
		}
		else{
			System.out.println("�������");
		}
	}
}
