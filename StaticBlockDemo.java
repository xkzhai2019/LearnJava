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

		// �޸ľ�̬���룬��ͬ����ͬʱ�仯
		// ���ж���ľ�̬�ֶζ�������
		ming.number = 80;
		System.out.println(ming.number);
		System.out.println(hong.number);
		hong.number = 90;
		System.out.println(hong.number);
		System.out.println(ming.number);

	}
}