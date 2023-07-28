/*
	售票
*/
class Saler extends Thread{
	private String name;
	//private int tickets = 100;
	private static int tickets = 100;

	// 锁
	private static Object lock = new Object();
	
	public Saler(String name){
		this.name = name;
	}

	public void run(){
		while(tickets>0){
			// 将一段代码原子化，解决并发访问问题
			synchronized(lock){
				int temp = tickets;
				try{
					Thread.sleep(10);	
				}
				catch(Exception e){	
				}
				tickets = temp-1;		
				System.out.println(name+" : "+temp);
			}
			yield();
			/*
			int temp = tickets;
			try{
				Thread.sleep(temp);	
			}
			catch(Exception e){	
			}
			tickets = temp-1;
			*/
		}
		//for(int i=tickets;i>0;i--){
		//	System.out.println(name+":"+i);
		//}
	}
}

class ThreadDemo6{
	public static void main(String[] args){
		Saler s1 = new Saler("Marry");
		Saler s2 = new Saler("John");
		s1.start();
		s2.start();
	}
}
