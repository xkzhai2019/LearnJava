/*
	����ӿ�
*/
interface USB {
	public static final int volta = 5;
	void trans();
}

/*
	ʵ����
*/
class PC implements USB{
	public void trans(){
		System.out.println("$$$$");
	}
}

class InterfaceDemo
{
	public static void main(String[] args){
		PC pc = new PC();
		pc.trans();
		System.out.println(pc.volta);
	}
}