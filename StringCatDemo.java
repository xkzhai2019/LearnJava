/*
	字符串连接
*/
class StringCatDemo{
	public static void main(String[] args){

		// 使用+
		int[] no = new int[]{1001,1002,1003,1004,1005};
		String[] names = new String[]{"张三","李四","王五","赵六","冯七"};
		String[] classes = new String[]{"数学","语文","英语","数学","数学",};

		System.out.println("本次考试学生信息如下：");
		for (int i=0;i<no.length ;i++ ){
			System.out.println("学号："+no[i]+"|姓名："+names[i]+"|课程："+classes[i]+"|班级："+"初二（三）班");
		}

		// 字符串长度过长时可分为多行
		String str = "Welcome to" + " Beijing "
		+"欢迎来到"+"北京";
		System.out.println(str);

		// 使用concat(),仅适用于String
		String info = "三国、";
		info = info.concat("水浒、");
		info = info.concat("红楼、");
		info = info.concat("西游");
		System.out.println(info);

		String cn = "中国";
		System.out.println(cn.concat("江苏").concat("苏州"));

	}
}
