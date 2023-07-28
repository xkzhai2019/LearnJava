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
	public void get(){
		return pool.remove(0);
	}
}

// 生产者
class Producer extends Thread{
}

// 消费者
class Consumer extends Thread{

}