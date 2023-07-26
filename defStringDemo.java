class defStringDemo{
	public static void main(String[] args){
		// 直接定义
		String str1 = "Hello,String1";
		String str2;
		str2 = "Hello,String2";
		System.out.println(str1);
		System.out.println(str2);

		str1 = "我是一只小鸟";
		str2 = "Let\'s say it\'s true";
		System.out.println(str1);
		System.out.println(str2);

		System.out.println("----------------");
		// 使用String类定义
		String str3 = new String("Hello,String3");
		String str4 = new String(str3);
		System.out.println(str3); // Hello,String3
		System.out.println(str4); // Hello,String3
		
		char a[] = {'H','e','l','l','o'};
		System.out.println(a); // Hello
		String sChar = new String(a); 
		a[0] = 'Y';
		System.out.println(a); // Yello
		System.out.println(sChar); // Hello; 修改a，不影响已创建的sChar

		String sChar2 = new String(a,2,3); 
		System.out.println(sChar2); // llo
		

	}
}
