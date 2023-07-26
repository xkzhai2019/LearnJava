class Benz{
	private String color = "black";
	private int tires;
	// 定义发动机成员变量
	private Engine engine = new Engine();

	/* 发动机内部类 */
	class Engine{
		private int power;
		//public void fire(){
		public  void fire(){
			System.out.println(color+"里面点火");
		}
	}
	
	public void run(){
		//Engine e = new Engine();
		//e.fire();

		engine.fire();

		//Benz.Engine.fire();
		//Engine.fire();
		System.out.println("开跑");
	}

	public String getColor(){
		return color;
	}

}

/* 发动机外部类 */
class Engine{
	private int power;
	//public void fire(){
	public static void fire(){
		System.out.println("外面点火");
	}
}


class InnerClassDemo{
	public static void main(String[] args){
		Benz benz = new Benz();
		System.out.println(benz.getColor());
		benz.run();
	}
}
