class Benz{
	private String color = "black";
	private int tires;
	
	public void run(){
		final int time = 120;
		/* 发动机内部类 */
		class Engine{
			private int power;
			public void fire(){
				//time = 100; // 不允许修改
				System.out.println(time);
				System.out.println(color+"里面点火");
			}
		}
		new Engine().fire();
		System.out.println("开跑");
	}

	public String getColor(){
		return color;
	}

}

class InnerClassDemo2{
	public static void main(String[] args){
		Benz benz = new Benz();
		System.out.println(benz.getColor());
		benz.run();
	}
}
