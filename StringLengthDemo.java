/*
	字符串长度
*/
class StringLengthDemo{
	public static void main(String[] args){
		String sys = "学生信息管理";
		System.out.println("欢迎使用《"+sys+"》系统");
		System.out.println("请设置一个管理员密码：");
		java.util.Scanner input = new java.util.Scanner(System.in);
		String pass = input.next();

		int length = pass.length();

		if(length>6 && length<12){
			System.out.println("密码长度符合规定");
			System.out.println("已生效，请牢记密码："+pass);
		}else if(length>=12){
			System.out.println("密码过长");
		}
		else{
			System.out.println("密码过短");
		}
	}
}
