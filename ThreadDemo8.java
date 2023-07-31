/*
	生产者-消费者
*/

class Pool{
	private java.util.List<Integer> pool = new java.util.ArrayList<Integer>();
	
	// 添加元素
	public void add(int i){
		pool.add(new Integer(i));
	}

	// 取元素
	public Integer cut(){
		if(pool.isEmpty()){
			return new Integer(0);
		}
		return pool.remove(0);
	}
}

// 生产者
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

// 消费者
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
				// 释放cpu抢占权，不释放锁旗标
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
		
		// 启动生产与消费
		p.start();
		c.start();
	}
}
