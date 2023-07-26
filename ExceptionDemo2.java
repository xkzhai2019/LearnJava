// 自定义异常
class AgeTooBigException extends Exception{
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
	public void setAge(int age) throws AgeTooBigException,AgeTooSmallException{
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

class ExceptionDemo2{
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
		}
//		catch(Exception ex){
//			ex.printStackTrace();
//		}

		/*
		catch(Exception ex){
			ex.printStackTrace();
		}
		// 不可达代码
		catch(AgeTooBigException ex){
			ex.printStackTrace();
		}
		*/
		System.out.println(p.getAge());
	}
}