class String2IntDemo{
	public static void main(String[] args){
		String str = "123";
		int n = 0;

		// ��һ��ת��
		n = Integer.parseInt(str);
		System.out.println("Integer.parseInt(str):"+n);

		// �ڶ���ת��
		n = 0;
		n = Integer.valueOf(str).intValue();
		System.out.println("Integer.parseInt(str):"+n);
	}
}