class Car{
	String color;
}

class Benz extends Car{
	public void fly(){
		System.out.println("�ɵ�̫����");
	}
}

// �̳��࣬��ʵ��Runnable�ӿ�
class BenzWrapper extends Benz implements Runnable{
	public void run(){
		this.fly();
	}
}

class RunnableDemo{
	public static void main(String[] args){
		new Thread(new BenzWrapper()).start();
	}
}