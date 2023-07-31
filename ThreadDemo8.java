/*
	������-������
*/

class Pool{
	private java.util.List<Integer> pool = new java.util.ArrayList<Integer>();
	
	// ���Ԫ��
	public void add(int i){
		pool.add(new Integer(i));
	}

	// ȡԪ��
	public Integer cut(){
		if(pool.isEmpty()){
			return new Integer(0);
		}
		return pool.remove(0);
	}
}

// ������
class Producer extends Thread{
	Pool pool;
	String name;

	public Producer(String name, Pool pool){
		this.pool = pool;
		this.name = name;
	}

	public void run(){
		int i = 1;
		while(true){
			pool.add(i);
			//System.out.println("Producer:"+i);
			i++;

		}
	}
}

// ������
class Consumer extends Thread{
	Pool pool;
	String name;
	public Consumer(String name, Pool pool){
		this.pool = pool;
		this.name = name;
	}
	public void run(){
		while(true){
			int tmp = pool.cut();
			System.out.println("Consumer:"+tmp);
			try{
				// �ͷ�cpu��ռȨ�����ͷ������
				Thread.sleep(100);
			}
			catch(Exception e){
			
			}
		}
	}
}

class ThreadDemo8{
	public static void main(String[] args){
		Pool pool = new Pool();
		Producer p = new Producer("k",pool);
		Consumer c = new Consumer("c",pool);
		
		// ��������������
		p.start();
		c.start();
	}
}
