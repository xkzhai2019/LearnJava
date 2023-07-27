// 自定义运行时异常
// 无需显式抛出声明
class AgeTooBigException extends RuntimeException{
	private String info;

	public AgeTooBigException(){
	}

	public AgeTooBigException(String info){
		this.info = info;
	}

	public String getInfo(){
		return info;
	}
	public void setInfo(String info){
		this.info = info;
	}
}

class AgeTooSmallException extends Exception{
	private String info;

	public AgeTooSmallException(){
	}

	public AgeTooSmallException(String info){
		this.info = info;
	}

	public String getInfo(){
		return info;
	}
	public void setInfo(String info){
		this.info = info;
	}
}

class Person{
	private int age;
	
	// 定义函数，声明异常
	public void setAge(int age) throws AgeTooSmallException{
		if(age>100){
			// 抛出年龄过大异常
			throw new AgeTooBigException("年龄太大");
		}
		else if(age<0){
			// 抛出年龄过小异常
			throw new AgeTooSmallException("年龄太小");
		}
		this.age = age;
	}

	public int getAge(){
		return age;
	}
}



class RuntimeExceptionDemo{
	public static void main(String[] args){
		Person p = new Person();

		// 调用函数，对异常进行处理
		try{
			p.setAge(-1);
		}
		catch(AgeTooBigException ex){
			System.out.println(ex.getInfo());
		}
		catch(AgeTooSmallException ex){
			System.out.println(ex.getInfo());
			//System.exit(-1);
		}
		finally{
			System.out.println("无论如何都要处理的");
		}

		System.out.println(p.getAge());
	}
}

// 年龄非法异常
class AgeInvalidException extends AgeTooSmallException{
}

// 中国人
class Chinese extends Person{
	// 覆盖方法时不能追加异常，除非新增异常为子异常
	public void setAge(int age) throws AgeInvalidException{
		if(age<0 || age>100){
			throw new AgeInvalidException();
		}
		/*
		try{
			super.setAge(age);
		}
		catch(Exception e){
		}
		finally{
			System.out.println("over!");
		}
		*/
	}
}