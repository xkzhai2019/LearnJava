// �Զ�������ʱ�쳣
// ������ʽ�׳�����
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
	
	// ���庯���������쳣
	public void setAge(int age) throws AgeTooSmallException{
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



class RuntimeExceptionDemo{
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
			//System.exit(-1);
		}
		finally{
			System.out.println("������ζ�Ҫ�����");
		}

		System.out.println(p.getAge());
	}
}

// ����Ƿ��쳣
class AgeInvalidException extends AgeTooSmallException{
}

// �й���
class Chinese extends Person{
	// ���Ƿ���ʱ����׷���쳣�����������쳣Ϊ���쳣
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