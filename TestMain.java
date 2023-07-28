class TestMain{
	public void speak1(){
		System.out.println("你好!");
	}
	public static void speak2(){
		System.out.println("Static method!");
	}

	public static void main(String[] args) {
		int n = args.length;
		System.out.println("共有"+n+"个参数");
		if(n>0){
			for(int i=0;i<n;i++){
				System.out.println(args[i]);
			}
		}

		System.out.println("---------------");

		//speek1(); //错误调用，main只能调用静态方法，非静态方法需要对象
		TestMain t = new TestMain();
		t.speak1();
		speak2();
	}
}
