// 票池
class TickPool{
	private int tickets = 100;
	// 同步方法，使用的当前对象作为锁旗标 -- this
	public synchronized int getTicket(){
		if(tickets<=0){
			return 0;
		}
		int tmp = tickets;
		tickets = tickets - 1;
		return tmp;
	}
}

class Saler extends Thread{
	private String name;
	TickPool pool;
	public Saler(String name,TickPool pool){
		this.name = name;
		this.pool = pool;
	}
	
	public void run(){
		while(true){
			int no = pool.getTicket();
			if(no!=0){
				System.out.println(name+":"+no);
			}
			else{
				return;
			}
		}
	}
}

class ThreadDemo7{
	public static void main(String[] args){
		TickPool pool = new TickPool();
		Saler s1 = new Saler("NO1",pool);
		Saler s2 = new Saler("NO2",pool);
		Saler s3 = new Saler("NO3",pool);
		s1.start();
		s2.start();
		s3.start();
	}
}