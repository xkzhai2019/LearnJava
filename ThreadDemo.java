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
			public void run(){
				System.out.println("2nd Thread");
			}
		};
		t2.start();
		System.out.println(t2.getName());
	}
}