class TestMain{
	public void speak1(){
		System.out.println("���!");
	}
	public static void speak2(){
		System.out.println("Static method!");
	}

	public static void main(String[] args) {
		int n = args.length;
		System.out.println("����"+n+"������");
		if(n>0){
			for(int i=0;i<n;i++){
				System.out.println(args[i]);
			}
		}

		System.out.println("---------------");

		//speek1(); //������ã�mainֻ�ܵ��þ�̬�������Ǿ�̬������Ҫ����
		TestMain t = new TestMain();
		t.speak1();
		speak2();
	}
}
