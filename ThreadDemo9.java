/*
	������-������
*/

// ������
class Producer extends Thread{
	final static int MAX = 1;
	java.util.List<Integer> list;
	String name;

	public Producer(String name, java.util.List<Integer> list){
		this.list = list;
		this.name = name;
	}

	public void run(){
		// �������
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

// ������
class Consumer extends Thread{
	java.util.List<Integer> list;
	String name;

	public Consumer(String name, java.util.List<Integer> list){
		this.list = list;
		this.name = name;
	}

	public void run(){
		// ȡ����
		while(true){
			synchronized(list){
				int size = list.size();
				// ����Ϊ��
				if(size==0){
					// ���뵽�����ĵȴ����У��ͷ�CPU��ռȨ���ͷ��������Ȩ
					try{
						list.wait(10);
					}
					catch(Exception e){
					}
				}
				else{
					Integer i = list.remove(0);
					System.out.println(name+":"+i);
					// ֪ͨ�ȴ������е��߳�
					list.notify(); // ������������,��Ҫ��wait���ʹ��
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
		
		// ��������������
		p.start();
		c1.start();
		c2.start();
	}
}
