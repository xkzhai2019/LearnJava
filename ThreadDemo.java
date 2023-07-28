class MyThread extends Thread{
	public void run(){
		System.out.println("run.....");
	}
}

class ThreadDemo{
	public static void main(String[] args){
		MyThread t1 = new MyThread();
		t1.start();
		System.out.println(t1.getName());
		System.out.println("---------------");
		//new Thread().start();

		Thread t2 = new Thread(){
			// 线程定义方法
			public void run(){
				System.out.println("2nd Thread");
				System.out.println("t2.current：" + Thread.currentThread().getName());
			}
		};
		// 开始执行
		t2.start();
		System.out.println(t2.getName());

		// 得到当前线程
		System.out.println("main.current:"+Thread.currentThread().getName());
	}
}