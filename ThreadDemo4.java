// �����߳�
class Box extends Thread{
	private String boxNo;
	private int sec;

	public Box(String boxNo,int sec){
		this.boxNo = boxNo;
		this.sec = sec;
	}

	public void run(){
		System.out.println(boxNo+"�Ű��᣺��ʼ��");
		try{
			Thread.sleep(sec*1000);
		}
		catch(Exception e){
		}
		System.out.println(boxNo+"�Ű��᣺������");
	}
}

// ����Ա�߳�
class Waiter extends Thread{
	private String name;
	private int ms;
	public Waiter(String name,int ms){
		this.name = name;
		this.ms = ms;
	}

	public void run(){
		while(true){
			try{
				System.out.println(name+"Ϊ����ʱ������ʱ�䣺"+new java.util.Date());
			    Thread.sleep(ms);		
			}
			catch(Exception e){
			
			}

		}
	}
}

class  ThreadDemo4{
	public static void main(String[] args) {

		Box b1 = new Box("001",1);
		Box b2 = new Box("002",4);
		Box b3 = new Box("003",5);
		
		Waiter w = new Waiter("�仨",1000);
		w.setDaemon(true); // �����ػ��߳�
		// �����߳�
		b1.start();
		b2.start();
		b3.start();
		w.start();

	}
}
