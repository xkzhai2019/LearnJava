class defStringDemo{
	public static void main(String[] args){
		// ֱ�Ӷ���
		String str1 = "Hello,String1";
		String str2;
		str2 = "Hello,String2";
		System.out.println(str1);
		System.out.println(str2);

		str1 = "����һֻС��";
		str2 = "Let\'s say it\'s true";
		System.out.println(str1);
		System.out.println(str2);

		System.out.println("----------------");
		// ʹ��String�ඨ��
		String str3 = new String("Hello,String3");
		String str4 = new String(str3);
		System.out.println(str3); // Hello,String3
		System.out.println(str4); // Hello,String3
		
		char a[] = {'H','e','l','l','o'};
		System.out.println(a); // Hello
		String sChar = new String(a); 
		a[0] = 'Y';
		System.out.println(a); // Yello
		System.out.println(sChar); // Hello; �޸�a����Ӱ���Ѵ�����sChar

		String sChar2 = new String(a,2,3); 
		System.out.println(sChar2); // llo
		

	}
}
