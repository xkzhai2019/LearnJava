class Benz{
	private String color = "black";
	private int tires;
	// ���巢������Ա����
	private Engine engine = new Engine();

	/* �������ڲ��� */
	class Engine{
		private int power;
		//public void fire(){
		public  void fire(){
			System.out.println(color+"������");
		}
	}
	
	public void run(){
		//Engine e = new Engine();
		//e.fire();

		engine.fire();

		//Benz.Engine.fire();
		//Engine.fire();
		System.out.println("����");
	}

	public String getColor(){
		return color;
	}

}

/* �������ⲿ�� */
class Engine{
	private int power;
	//public void fire(){
	public static void fire(){
		System.out.println("������");
	}
}


class InnerClassDemo{
	public static void main(String[] args){
		Benz benz = new Benz();
		System.out.println(benz.getColor());
		benz.run();
	}
}
