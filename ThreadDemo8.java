/*
	������-������
*/

class Pool{
	private java.util.List<Integer> pool = new java.util.ArrayList<Integer>();
	
	// ���Ԫ��
	public void add(int i){
		pool.add(new Integer(i));
	}

	// ȡԪ��
	public void get(){
		return pool.remove(0);
	}
}

// ������
class Producer extends Thread{
}

// ������
class Consumer extends Thread{

}