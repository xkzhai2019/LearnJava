/*
	生产-消费的另类实现
*/

class Productor extends Thread{
	private String name;
	private java.util.List<Integer> list;
	
	public Productor(String name, java.util.List<Integer> list){
		this.name = name;
		this.list = list;
	}

	public void run(){
		int i = 0;
		while(true){
			list.add(new Integer(i++));
			System.out.println(name+"生产了："+i);
		}
	}
}

class Consumer extends Thread{
	private String name;
	private java.util.List<Integer> list;
	
	public Consumer(String name, java.util.List<Integer> list){
		this.name = name;
		this.list = list;
	}
	public void run(){
		while(true){
			if(list.size()>0){
				int i = list.remove(0);
				System.out.println(name + "取出了："+i);
			}
		}
	}
}
class ThreadDemo11{
	public static void main(String[] args){
		java.util.List<Integer> list = new java.util.ArrayList<Integer>();
		Productor p1 = new Productor("生产者",list);
		Consumer c1 = new Consumer("消费者",list);

		p1.start();
		c1.start();
	}
}
