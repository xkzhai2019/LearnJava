/*
* �����࣬Person
*/
abstract class Person {
	
	public String name;

	public Person(){
		System.out.println("new Person()");
	}

	public Person(String name){
		this();
		this.name = name;
	}
	
	// ���󷽷�
	//static abstract public void speak(); //�Ƿ����δ����: abstract+final abstract+private
	abstract public void speak();
	
	// ���巽��
	public void speakAlound(){
		System.out.println("��������");
		speak();
	}

}
/*
* �����࣬Man
*/
class Man extends Person{
	public Man(){
		System.out.println("new Man()");
	}
	
	public void speak(){
		System.out.println("����");
	}


}

class AbstractDemo
{
	public static void main(String[] args){
		//Person p = new Person();
		Man m = new Man();
		m.speak();
		m.speakAlound();
	}
}