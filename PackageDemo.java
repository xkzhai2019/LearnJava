// 完整类名a.a1.A --> a/a1/A.class
// 源文件PackageDemo.java
package a.a1;

import java.util.Date;

// 新建a与a1文件夹方可执行
// java a.a1.A

// 也可以编译时指定
// javac -d . xxx.java

// 外层文件夹下执行,需指定classpath 
// java -cp ./ a.a1.A


class A{
	public static void main(String[] args){
		System.out.println("Hello package");
		Date d = new Date();
		System.out.println(d);
	}
}
