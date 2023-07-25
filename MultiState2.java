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

class MultiStateDemo2
{
	public static void main(String[] args){
		womenStar w1 = new womenStar();
		IWhite w2 = new womenStar();
		IRich w3 = new womenStar();
	}
}


