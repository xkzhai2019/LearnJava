class ThreadPriority{
	public static Object lock = new Object();
	public static void main(String[] args){
		/*
		MyThread a = new MyThread("A");
		System.out.println(a.getPriority());
		a.setPriority(10);
		MyThread b = new MyThread("B");

		a.start();
		b.start();
		*/
		for(int i=1;i<=10;i++){
			new MyThread("Thread-"+i,i).start();
		}
		while(true){
			synchronized(lock){
				//while(true){
					lock.notify();
				//}
			}
		}
	}
}

class MyThread extends Thread{
	private String name;
	public MyThread(String name,int pri){
		this.name = name;
		this.setPriority(pri);
	}
	public void run(){
		synchronized(ThreadPriority.lock){
			while(true){
				try{
					System.out.println(name);	
					ThreadPriority.lock.wait();
				}
				catch(Exception e){
					
				}
			}
		}
	}
}