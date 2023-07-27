class String2IntDemo{
	public static void main(String[] args){
		String str = "123";
		int n = 0;

		// 第一种转换
		n = Integer.parseInt(str);
		System.out.println("Integer.parseInt(str):"+n);

		// 第二种转换
		n = 0;
		n = Integer.valueOf(str).intValue();
		System.out.println("Integer.parseInt(str):"+n);
	}
}