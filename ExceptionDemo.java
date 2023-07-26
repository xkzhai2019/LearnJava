class Person{
	private int age;
	
	// ���庯���������쳣
	public void setAge(int age) throws Exception{
		if(age<0 || age>100){
			// �׳��쳣
			throw new Exception("����Ƿ�");
		}
		this.age = age;
	}

	public int getAge(){
		return age;
	}
}

class ExceptionDemo{
	public static void main(String[] args){
		Person p = new Person();

		// ���ú��������쳣���д���
		try{
			p.setAge(120);
		}
		catch(Exception e){
			e.printStackTrace();
		}
		
	}
}