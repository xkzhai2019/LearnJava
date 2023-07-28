class MyThread extends Thread{
	public void run(){
		while(true){
			System.out.println(getName());
			// 让当前线程休眠指定毫秒数
			try{
				Thread.sleep(100);
			}
			catch(Exception e){
			
			}
			// 让当前线程放弃cpu抢占权
			//yield();
		}
		
	}
}

class ThreadDemo2{
	public static void main(String[] args){
		MyThread t1 = new MyThread();
		t1.start();

		MyThread t2 = new MyThread();
		t2.start();
	}
}