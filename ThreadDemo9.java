/*
	生产者-消费者
*/

// 生产者
class Producer extends Thread{
	final static int MAX = 1;
	java.util.List<Integer> list;
	String name;

	public Producer(String name, java.util.List<Integer> list){
		this.list = list;
		this.name = name;
	}

	public void run(){
		// 存放数据
		int i = 1;
		while(true){
			synchronized(list){
				int size = list.size();
				if(size >= MAX){
					try{
						list.wait(10);
					}
					catch(Exception e){
					}
					
				}
				else{
					list.add(new Integer(i));
					System.out.println(name+":"+i);
					i++;

					list.notify();
					//list.notifyAll();
				}
			}
			yield();
		}
	}
}

// 消费者
class Consumer extends Thread{
	java.util.List<Integer> list;
	String name;

	public Consumer(String name, java.util.List<Integer> list){
		this.list = list;
		this.name = name;
	}

	public void run(){
		// 取数据
		while(true){
			synchronized(list){
				int size = list.size();
				// 集合为空
				if(size==0){
					// 进入到锁旗标的等待队列，释放CPU抢占权，释放锁旗标监控权
					try{
						list.wait(10);
					}
					catch(Exception e){
					}
				}
				else{
					Integer i = list.remove(0);
					System.out.println(name+":"+i);
					// 通知等待队列中的线程
					list.notify(); // 存在死锁可能,需要与wait配合使用
					//list.notifyAll();
				}
			}
			yield();
		}
	}
}

class ThreadDemo9{
	public static void main(String[] args){
		java.util.List<Integer> list = new java.util.ArrayList<Integer>();
		Producer p = new Producer("p",list);
		Consumer c1 = new Consumer("c1",list);
		Consumer c2 = new Consumer("c2",list);
		
		// 启动生产与消费
		p.start();
		c1.start();
		c2.start();
	}
}
