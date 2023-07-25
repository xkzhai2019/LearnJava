// 多态
abstract class Animal{
	public String name;
	public abstract void cry();

}

class Dog extends Animal{
	public String color;
	public void cry(){
		System.out.println("wangwang");
	}
}

class Jing8 extends Dog{
	public String xxx;
	//public String color; //属性无法覆盖
	public void cry(){
		super.cry();
		System.out.println("~~~~~~");
	}
}

class MultiStateDemo{
	public static void main(String[] args){
		Jing8 dog = new Jing8();
		dog.cry();   // wangwang ~~~~~~~~~
		
		Dog d2 = dog;
		d2.cry();    // wangwang ~~~~~~~~~
		
		Animal d3 = dog;
		d3.cry();    // wangwang ~~~~~~~~~

		System.out.println("----------------");
		Jing8 d4 = new Jing8();
		d4.color = "white";
		System.out.println(d4.color); // white
		
		Dog d5 = d4;
		d5.color = "black";
		System.out.println(d5.color); // black
		System.out.println(d4.color); // black
		
		//Dog dog = new Jing8();
		/*
		dog.name = "大黄";
		dog.color = "yellow";
		dog.xxx = "xxx";
		System.out.println(dog.name);
		
		Dog d2 = new Jing8();
		System.out.println(d2.name);

		Animal d3 = new Jing8();
		System.out.println(d3.name);

		Jing8 d4 = new Dog();
		*/
	}

}