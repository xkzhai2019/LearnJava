class BeeBearDemo{
	public static void main(String[] args){
		Box box = new Box();
		for(int i=1;i<=100;i++){
			new Bee("Bee-"+i,box).start();
		}
		new Bear("x1",box).start();
		new Bear("x2",box).start();
	}
}

// 蜜蜂
class Bee extends Thread{
	private String name;
	private Box box;
	
	public Bee(String name, Box box){
		this.name = name;
		this.box = box;
	}

	public void run(){
		while(true){
			int n = box.add();
			System.out.println(name+"生产了蜂蜜,box："+n);
		}
	}
}	

// 熊
class Bear extends Thread{
	private String name;
	private Box box;
	
	public Bear(String name, Box box){
		this.name = name;
		this.box = box;
	}

	public void run(){
		while(true){
			box.remove();
			System.out.println(name+"吃掉了蜂蜜");
		}
	}
}	

// 蜜罐
class Box{
	private int MAX = 20;
	private int count;

	// 添加蜂蜜,+1
	public synchronized int add(){
		// 不可用if，if只判断当前值
		while(count >= MAX){
			this.notify();
			try{
				this.wait();
			}
			catch(Exception e){
				e.printStackTrace();
			}

		}
		return ++count;
	}

	// 移除蜂蜜,-MAX
	public synchronized void remove(){
		while(count < MAX){
			try{
				this.wait();
			}
			catch(Exception e){
				e.printStackTrace();
			}
		}
		count = 0;
		this.notify();
	}
}

