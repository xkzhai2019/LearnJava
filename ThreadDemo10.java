/*
	ͬ����̬������������Ϊͬ�����
*/

// Ʊ��
class TicketPool{
	private static int tickets = 100;
	public synchronized static int getTicket(){
		// �Ǿ�̬������Ʊ�ر�����Ϊ�����
		int temp = tickets;
		tickets = tickets - 1;
		return temp > 0? temp:0;
	}
}


class Saler extends Thread{
	private String name;
	//TickPool pool;
	//public Saler(String name,TickPool pool){
	public Saler(String name){
		this.name = name;
		//this.pool = pool;
	}
	
	public void run(){
		while(true){
			int no = TicketPool.getTicket();
			if(no!=0){
				System.out.println(name+":"+no);
				Thread.yield();
			}
			else{
				return;
			}
		}
	}
}

class ThreadDemo10{
	public static void main(String[] args){
		//TickPool pool = new TickPool();
		Saler s1 = new Saler("NO1");
		Saler s2 = new Saler("NO2");
		Saler s3 = new Saler("NO3");
		s1.start();
		s2.start();
		s3.start();
	}
}
