class Player extends Thread{
	private String name;
	// ·�ϻ���ʱ��
	private int seconds;

	public void run(){
		try{
			System.out.println("���--"+name+"��������");
			Thread.sleep(seconds*1000);
			System.out.println("���--"+name+"�����ˣ�����"+seconds+"��");
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
		Player p1 = new Player("����",1); //������Ҫ�ȴ����ӵ������ų���
		Player p2 = new Player("������",2);
		Player p3 = new Player("��С��",2);
		Player p4 = new Player("���ӵ�",3);

		p2.start();
		p3.start();
		p4.start();
		
		// join�ǵȴ�ִ�е��߳̽���
		p2.join();
		p3.join();
		p4.join();

		p1.start();
		p1.join();
		System.out.println("���Կ��֣�");
	}
} 
