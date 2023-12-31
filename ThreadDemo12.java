/*
	生产-消费的另类实现
*/

class Pool{
	private java.util.List<Integer> list = new java.util.ArrayList<Integer>();
	// 容器最大值
	//private int MAX = 100;
	private int MAX = 1;
	// 添加元素
	public void add(int n){
		// 锁旗标的监控权
		synchronized(this){
			try{
				String name = Thread.currentThread().getName();
				while(list.size() >= MAX){
					// 放弃锁旗标监控权
					System.out.println(name+".wait()");
					this.wait();
					//System.out.println("xxxxx");
				}
				list.add(n);
				//System.out.println("size:"+list.size());
				System.out.println(name+" +:"+n);
				System.out.println(name+".notify()");
				this.notify();
			}
			catch(Exception e){
			}	
		}
	}
	
	// 删除元素
	public int remove(){
		synchronized(this){
			try{
				String name = Thread.currentThread().getName();
				while(list.size() == 0){
					System.out.println(name+".wait()");
					this.wait();
				}
				int i =list.remove(0);
				System.out.println(name+" -:"+i);
				System.out.println(name+".notify()");
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
			/*
			try{
				//Thread.sleep(100);
			}
			catch(Exception e){
				
			}
			*/
			//System.out.println(name+"生产了："+i);
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
			pool.remove();
			/*
			try{
				//Thread.sleep(100);
			}
			catch(Exception e){
				
			}
			*/
			//System.out.println(name+"消费了："+i);
		}
	}
}
class ThreadDemo12{
	public static void main(String[] args){
		Pool pool = new Pool();
		Productor p1 = new Productor("生产者1",pool);
		p1.setName("p1");
		//Productor p2 = new Productor("生产者2",pool);
		Consumer c1 = new Consumer("消费者1",pool);
		c1.setName("c1");
		Consumer c2 = new Consumer("消费者2",pool);
		c2.setName("c2");

		p1.start();
		//p2.start();
		c1.start();
		c2.start();
	}
}
