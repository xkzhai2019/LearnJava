/*
“∞ ﬁ¿‡
*/
class Beast{
	public String name;
	public int age;


	public String getName(){
		return name;
	}

	public void hehe(){
		System.out.println("hehe");
	}
	public void eat(){
		System.out.println("eta...");
	}

	// ¡‹‘°
	private void shower(){
	
	}

	public Beast(){
		System.out.println("new Beast");
	}
}

class Tiger extends Beast{
	public String color = "yellow";

	public void eat(){
		super.eat();
		System.out.println("~~~~EAT~~~~~~");
	}
	public Tiger(){
		System.out.println("new Tiger");
	}
}
class Lion extends Beast{

}
/*
	∂´±±ª¢
*/
class NeTiger extends Tiger{
	public NeTiger(){
		System.out.println("new NeTiger");
	}
}

class ExtendsDemo
{
	public static void main(String[] args){
		Tiger t = new Tiger();
		System.out.println(t.name);
		t.hehe();
		t.eat();

		Lion l = new Lion();
		l.hehe();

		NeTiger net = new NeTiger();
		System.out.println(net.color);
		net.eat();
	}
}