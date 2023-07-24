interface IWhite{
	public void white();
} 

interface IRich{
	public void rich();
}

interface IBeauty{
	public void beauty();
}

interface IWRB extends IWhite, IRich, IBeauty{
	
}

interface IDriver{
	void drive();
}

class womenStar implements IWRB{
	public void white(){
		System.out.println("I'm white");
	}
	public void rich(){
		System.out.println("I'm rich");
	}
	public void beauty(){
		System.out.println("I'm beauty");
	}
}

// 会开车的女明星
class womanStarDriver extends womenStar implements IDriver{
	public void drive(){
		System.out.println("慢慢开");
	}
}

class Richman{
	public void marry(IWRB woman){
		System.out.println("聊聊看");
	}
	public void drive(IDriver driver){
		driver.drive();
	}
}

class MarryDemo
{
	public static void main(String[] args){
		Richman man = new Richman();
		womenStar star = new womenStar();
		man.marry(star);
		womanStarDriver mstar = new womanStarDriver();
		man.drive(mstar);
	}
}


