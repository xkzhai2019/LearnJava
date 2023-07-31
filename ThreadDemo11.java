/*
	����-���ѵ�����ʵ��
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
			System.out.println(name+"�����ˣ�"+i);
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
				System.out.println(name + "ȡ���ˣ�"+i);
			}
		}
	}
}
class ThreadDemo11{
	public static void main(String[] args){
		java.util.List<Integer> list = new java.util.ArrayList<Integer>();
		Productor p1 = new Productor("������",list);
		Consumer c1 = new Consumer("������",list);

		p1.start();
		c1.start();
	}
}
