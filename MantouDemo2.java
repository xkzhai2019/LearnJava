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
	private static int MAX = 3; // ���幤��������ͷ�������
	private int count;
	private Basket basket;

	public Worker(String name, Basket basket){
		this.name = name;
		this.basket = basket;
	}

	public void run(){
		while(true){
			// 1.�ж��Ƿ��Ѿ��Ա�
			if(count >= MAX){
				return;
			}
			// 2.ȡ��ͷ
			int no = basket.getMantou();
			if(no==0){
				return;
			}
			// 3.����ͷ
			count++;
			System.out.println(name+"����"+"��"+no+"����ͷ");
		}
	}
}

class Basket{
	private int count = 100;
	
	// ͬ���������Ե�ǰ������Ϊ�����
	public synchronized int getMantou(){
		int tmp = count;
		count--;
		return tmp>0 ? tmp:0;
	}
}
