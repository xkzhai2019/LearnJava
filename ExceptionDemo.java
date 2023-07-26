class Person{
	private int age;
	
	// 定义函数，声明异常
	public void setAge(int age) throws Exception{
		if(age<0 || age>100){
			// 抛出异常
			throw new Exception("年龄非法");
		}
		this.age = age;
	}

	public int getAge(){
		return age;
	}
}

class ExceptionDemo{
	public static void main(String[] args){
		Person p = new Person();

		// 调用函数，对异常进行处理
		try{
			p.setAge(120);
		}
		catch(Exception e){
			e.printStackTrace();
		}
		
	}
}