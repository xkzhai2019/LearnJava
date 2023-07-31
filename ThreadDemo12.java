/*
	����-���ѵ�����ʵ��
*/

class Pool{
	private java.util.List<Integer> list = new java.util.ArrayList<Integer>();
	// �������ֵ
	//private int MAX = 100;
	private int MAX = 1;
	// ���Ԫ��
	public void add(int n){
		// �����ļ��Ȩ
		synchronized(this){
			try{
				while(list.size() >= MAX){
					// �����������Ȩ
					this.wait();
					//System.out.println("xxxxx");
				}
				list.add(n);
				System.out.println("size:"+list.size());
				this.notify();
			}
			catch(Exception e){
			}	
		}
	}
	
	// ɾ��Ԫ��
	public int remove(){
		synchronized(this){
			try{
				while(list.size() == 0){
					this.wait();
				}
				int i =list.remove(0);
				this.notify();
				return i;
			}
			catch(Exception e){
			}
			return -1;
		}
	}

}

class Productor extends Thread{
	private String name;
	private Pool pool;
	static int i = 0;
	
	public Productor(String name, Pool pool){
		this.name = name;
		this.pool = pool;
	}

	public void run(){
		//int i = 0;
		while(true){
			pool.add(i++);
			try{
				//Thread.sleep(100);
			}
			catch(Exception e){
				
			}
			System.out.println(name+"�����ˣ�"+i);
		}
	}
}

class Consumer extends Thread{
	private String name;
	private Pool pool;
	
	public Consumer(String name, Pool pool){
		this.name = name;
		this.pool = pool;
	}
	public void run(){
		while(true){
			int i = pool.remove();
			try{
				//Thread.sleep(100);
			}
			catch(Exception e){
				
			}
			System.out.println(name+"�����ˣ�"+i);
		}
	}
}
class ThreadDemo12{
	public static void main(String[] args){
		Pool pool = new Pool();
		Productor p1 = new Productor("������1",pool);
		//Productor p2 = new Productor("������2",pool);
		Consumer c1 = new Consumer("������1",pool);
		Consumer c2 = new Consumer("������2",pool);

		p1.start();
		//p2.start();
		c1.start();
		c2.start();
	}
}
