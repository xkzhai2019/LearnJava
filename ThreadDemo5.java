/*
	ÊÛÆ±
*/
class Saler extends Thread{
	private String name;
	//private int tickets = 100;
	private static int tickets = 100;
	public Saler(String name){
		this.name = name;
	}

	public void run(){
		while(tickets>0){
			System.out.println(name+" : "+tickets--);
		}
		//for(int i=tickets;i>0;i--){
		//	System.out.println(name+":"+i);
		//}
	}
}

class ThreadDemo5{
	public static void main(String[] args){
		Saler s1 = new Saler("Marry");
		Saler s2 = new Saler("John");
		s1.start();
		s2.start();
	}
}
