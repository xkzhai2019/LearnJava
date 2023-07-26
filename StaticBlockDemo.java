class Person{
	public String name;
	public int age;

	public static int number;

	public Person(String name,int age){
		this.name = name;
		this.age = age;
	}
}

class StaticBlockDemo{
	public static void main(String[] args){
		Person ming = new Person("Ming",12);
		Person hong = new Person("Hong",15);

		// 修改静态代码，不同对象同时变化
		// 所有对象的静态字段都被改了
		ming.number = 80;
		System.out.println(ming.number);
		System.out.println(hong.number);
		hong.number = 90;
		System.out.println(hong.number);
		System.out.println(ming.number);

	}
}