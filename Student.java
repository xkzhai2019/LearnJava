/**
 * Student Bean. model
 */
class Student{
	private String name;
	private int age;
	public String getName(){
		return name;
	}

	public void setName(String name){
		this.name = name;
	}

	public int getAge(){
		return age;
	}

	public void setAge(int age){
		if(age <=0 || age > 100){
			System.out.println("年龄非法");
			return;
		}
		this.age = age;
	}

	public void setAge2(int age){
		if(validateAge(age)){
			this.age = age;
		}
		else{
			System.out.println("年龄非法");
		}
	}

	 //校验Age
	private boolean validateAge(int age){
		if(0<age && age<100){
			return true;
		}
		return false;
	}

}

class BeanDemo{
	public static void main(String[] args){
		Student s1 = new Student();
		s1.setName("tom");
		s1.setAge(10);
		System.out.println(s1.getAge());
	}
}