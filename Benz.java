class Benz{
	//��̬��Ա
	private static String brand = "X";
	// ��̬�����
	public static String getBrand(){
		return brand;
	}
	static{
		System.out.println("���ᣡ");
		System.out.println(brand);
		System.out.println("����!");
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

		// ����Benz��
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