class Benz{
	private String color = "black";
	private int tires;
	
	public void run(){
		final int time = 120;
		/* �������ڲ��� */
		class Engine{
			private int power;
			public void fire(){
				//time = 100; // �������޸�
				System.out.println(time);
				System.out.println(color+"������");
			}
		}
		new Engine().fire();
		System.out.println("����");
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
