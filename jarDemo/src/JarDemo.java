package com.xkzhai;

// µº»Î¿‡
import a.a1.PersonForJar;


// javac -cp lib/myjar.jar -d classes src/JarDemo.java

// java -cp lib/myjar.jar;classes/ com.xkzhai.JarDemo
class JarDemo{
	public static void main(String[] args){
		PersonForJar p = new PersonForJar();
		System.out.println(p);
	}
}