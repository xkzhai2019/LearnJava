class CodeBlockDemo{	
	public static void main(String[] args){

		/*
		// 局部代码块：函数内部定义
		{
			int x;
		}
		
		{
			int y = x;
		}
		*/
		new Dog();
		// 静态代码块只存在于类成员这一级别
		//static {
		//}
		
	}

	static {
		System.out.println("Constructor block: 0");
	}
}

class Dog{
	public String name;

	// 构造代码块：类的成员
	{
		System.out.println("Constructor block: -1");
	}
	
	// 构造对象时，先调用构造代码块，然后是构造函数
	public Dog(){
		System.out.println("new Dog()");
	}
	
	// +static修饰---->静态代码块
	// 静态代码块在类加载的时候执行，而且只执行一次
	static {
		System.out.println("Constructor block: -2");
	}
}