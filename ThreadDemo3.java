class Player extends Thread{
	private String name;
	// 路上花费时间
	private int seconds;

	public void run(){
		try{
			System.out.println("玩家--"+name+"：出发了");
			Thread.sleep(seconds*1000);
			System.out.println("玩家--"+name+"：到了，花了"+seconds+"秒");
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}

	public Player(String name, int sec){
		this.name = name;
		this.seconds = sec;
	}
}

class ThreadDemo3{
	public static void main(String[] args) throws Exception{
		Player p1 = new Player("成龙",1); //成龙需要等待甄子丹到达后才出发
		Player p2 = new Player("李连杰",2);
		Player p3 = new Player("李小龙",2);
		Player p4 = new Player("甄子丹",3);

		p2.start();
		p3.start();
		p4.start();
		
		// join是等待执行的线程结束
		p2.join();
		p3.join();
		p4.join();

		p1.start();
		p1.join();
		System.out.println("可以开局！");
	}
} 
