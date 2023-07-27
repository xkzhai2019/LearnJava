class Int2StringDemo{
	public static void main(String[] args){
		int num = 10;

		// 第一种方法：String.valueOf(i)
		String str = String.valueOf(num);
		System.out.println("str:"+str);

		// 第二种方法：Integer.toString(i)
		String str2 = Integer.toString(num);
		System.out.println("str2:"+str2);

		// 第三种方法："" + i
		String str3 = num + "";
		System.out.println("str3:"+str3);
	}
}