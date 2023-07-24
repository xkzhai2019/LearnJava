/*
* 抽象类，Person
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
	
	// 抽象方法
	//static abstract public void speak(); //非法修饰词组合: abstract+final abstract+private
	abstract public void speak();
	
	// 具体方法
	public void speakAlound(){
		System.out.println("调高音量");
		speak();
	}

}
/*
* 具体类，Man
*/
class Man extends Person{
	public Man(){
		System.out.println("new Man()");
	}
	
	public void speak(){
		System.out.println("川话");
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