class Car{
	String color;
}

class Benz extends Car{
	public void fly(){
		System.out.println("飞得太低了");
	}
}

// 继承类，并实现Runnable接口
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