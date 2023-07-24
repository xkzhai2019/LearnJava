class  Animal{
	// 常量，不可改变
	public final int FEETS=4;
	void cry(){
		System.out.println("cry~~~~~~~~~~~~~");
	}
	public Animal(int n){
		// super();
		//this.feets = n;
		System.out.println("new Animal");
	}
}

class Dog extends Animal 
{
	public String name;
	public int age;
	//private void cry()
	public void cry(){
		
		System.out.println("wangwang~~~~");
		super.cry();
	}
	public Dog(int feets){
		super(feets);
		System.out.println("new Dog");
	}

	public Dog(int feets, String name){
		//super(feets);
		this(feets);
		this.name = name;
	}
	public Dog(int feets,String name,int age){
		this(feets,name);
		this.age = age;
	}

	public static void main(String[] args){
		Dog dog = new Dog(4);
		dog.cry();
	}
	private final void run(){
		System.out.println("run......");
	}
}


class Jing8 extends Dog{
	public Jing8(int feets){
		super(feets);
	}
	public void cry(){
		super.cry();
		System.out.println("!!!!");
	}
}