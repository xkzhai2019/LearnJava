// ∂‡Ã¨
class Animal{
	public String name;

}

class Dog extends Animal{
	public String color;
}

class Jing8 extends Dog{
	public String xxx;
}

class MultiStateDemo{
	public static void main(String[] args){
		Jing8 dog = new Jing8();
		//Dog dog = new Jing8();
		dog.name = "¥Ûª∆";
		dog.color = "yellow";
		dog.xxx = "xxx";
		System.out.println(dog.name);
		
		Dog d2 = new Jing8();
		System.out.println(d2.name);

		Animal d3 = new Jing8();
		System.out.println(d3.name);

		Jing8 d4 = new Dog();
	}

}