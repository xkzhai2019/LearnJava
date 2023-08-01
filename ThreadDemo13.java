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
			System.out.println(name+"进洞了");
			try{
				cave.wait();
			}catch(Exception e){}
			
			System.out.println(name+"wait后代码");
		}
	}
}


class ThreadDemo13{
	public static void main(String[] args){
		Cave cave = new Cave();
		Car c1 = new Car(cave,"奔驰");
		Car c2 = new Car(cave,"宝马");
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