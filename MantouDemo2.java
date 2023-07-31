class MantouDemo2{
	public static void main(String[] args){
		Basket basket = new Basket();
		for(int i=1;i<=40;i++){
			new Worker("Worker-"+i,basket).start();
		}
	}
}

class Worker extends Thread{
	private String name;
	private static int MAX = 3; // 定义工人所吃馒头的最大数
	private int count;
	private Basket basket;

	public Worker(String name, Basket basket){
		this.name = name;
		this.basket = basket;
	}

	public void run(){
		while(true){
			// 1.判断是否已经吃饱
			if(count >= MAX){
				return;
			}
			// 2.取馒头
			int no = basket.getMantou();
			if(no==0){
				return;
			}
			// 3.拿馒头
			count++;
			System.out.println(name+"吃了"+"第"+no+"个馒头");
		}
	}
}

class Basket{
	private int count = 100;
	
	// 同步方法，以当前对象作为锁旗标
	public synchronized int getMantou(){
		int tmp = count;
		count--;
		return tmp>0 ? tmp:0;
	}
}
