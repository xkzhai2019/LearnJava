class Father{
	// 资产属性
	private int asset = 10000;
	
	public void setAsset(int asset){
		this.asset = asset;
	}
	public int getAsset(){
		return asset;
	}
}

class Son extends Father{
	public int asset = 100;
	public void setAsset(int asset){
		this.asset = asset;
	}
	public int getAsset(){
		return asset;
	}

	// 访问父类资产
	public int getFatherAsset(){
		return super.getAsset();
	}
}

class MultiStateDemo3{
	public static void main(String[] args){
		Son s = new Son();
		//System.out.println(s.getAsset()); // 10000
		s.setAsset(500); // self = 500
		//System.out.println(s.getAsset()); // 500
		//System.out.println(s.asset); //100
		//System.out.println(s.asset); //500
		//System.out.println(s.getAsset()); // 10000

		System.out.println(s.asset); //500
		System.out.println(s.getAsset()); // 500
		System.out.println("---------------");

		Son ss = new Son();
		Father ff = ss;
		ff.setAsset(800);
		System.out.println(ss.asset); //800
		
		ss.setAsset(900);
		System.out.println(ff.getAsset()); //900? || 1000?

		// 得到父类资产
		System.out.println(ss.getFatherAsset());
	}
}