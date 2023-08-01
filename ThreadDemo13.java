class Cave{

}

class Car extends Thread{
	Cave cave;
	String name;
	public Car(Cave cave,String name){
		this.cave = cave;
		this.name = name;
	}
	public void run(){
		synchronized(cave){
			System.out.println(name+"������");
			try{
				cave.wait();
			}catch(Exception e){}
			
			System.out.println(name+"wait�����");
		}
	}
}


class ThreadDemo13{
	public static void main(String[] args){
		Cave cave = new Cave();
		Car c1 = new Car(cave,"����");
		Car c2 = new Car(cave,"����");
		c1.start();
		c2.start();

		try{
			Thread.sleep(5000);
			synchronized(cave){
				//cave.notify();
				cave.notifyAll();
			}
		}
		catch(Exception e){
			
		}

		
	}
}