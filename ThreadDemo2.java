class MyThread extends Thread{
	public void run(){
		while(true){
			System.out.println(getName());
			// �õ�ǰ�߳�����ָ��������
			try{
				Thread.sleep(100);
			}
			catch(Exception e){
			
			}
			// �õ�ǰ�̷߳���cpu��ռȨ
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