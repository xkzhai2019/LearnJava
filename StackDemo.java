/**
ѹջ����
*/
class StackDemo{
	static int count = 0;

	
	public static void main(String[] args) throws Exception{
		out();
	}
	// �ݹ鷽������
	public static void out() throws Exception{
		System.out.println(count++);
		Thread.sleep(1);
		//if(count < 800){
			out();
		//}
	}

}