class Benz{
	//静态成员
	private static String brand = "X";
	// 静态代码块
	public static String getBrand(){
		return brand;
	}
	static{
		System.out.println("喷漆！");
		System.out.println(brand);
		System.out.println("打蜡!");
	}
	public Benz(){
		System.out.println("new Benz()");
	}
}

class BenzDemo{
	public static void main(String[] args) throws Exception{
		/*
		Benz benz;// = new Benz();
		//System.out.println(Benz.brand);
		System.out.println(Benz.getBrand());
		*/

		// 加载Benz类
		//Class.forName("Benz");
		Class.forName("Benz",false,BenzDemo.class.getClassLoader());
		

		//Class.forName("Benz");
		//Class.forName("Benz");
		//Class.forName("Benz");

		System.out.println("----------------");
		new Benz();
		new Benz();
	}
}