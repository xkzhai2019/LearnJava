class CodeBlockDemo{	
	public static void main(String[] args){

		/*
		// �ֲ�����飺�����ڲ�����
		{
			int x;
		}
		
		{
			int y = x;
		}
		*/
		new Dog();
		// ��̬�����ֻ���������Ա��һ����
		//static {
		//}
		
	}

	static {
		System.out.println("Constructor block: 0");
	}
}

class Dog{
	public String name;

	// �������飺��ĳ�Ա
	{
		System.out.println("Constructor block: -1");
	}
	
	// �������ʱ���ȵ��ù������飬Ȼ���ǹ��캯��
	public Dog(){
		System.out.println("new Dog()");
	}
	
	// +static����---->��̬�����
	// ��̬�����������ص�ʱ��ִ�У�����ִֻ��һ��
	static {
		System.out.println("Constructor block: -2");
	}
}