// �Զ����쳣
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
	
	// ���庯���������쳣
	public void setAge(int age) throws AgeTooBigException,AgeTooSmallException{
		if(age>100){
			// �׳���������쳣
			throw new AgeTooBigException("����̫��");
		}
		else if(age<0){
			// �׳������С�쳣
			throw new AgeTooSmallException("����̫С");
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

		// ���ú��������쳣���д���
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
		// ���ɴ����
		catch(AgeTooBigException ex){
			ex.printStackTrace();
		}
		*/
		System.out.println(p.getAge());
	}
}