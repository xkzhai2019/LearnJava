// ��������a.a1.A --> a/a1/A.class
// Դ�ļ�PackageDemo.java
package a.a1;

import java.util.Date;

// �½�a��a1�ļ��з���ִ��
// java a.a1.A

// Ҳ���Ա���ʱָ��
// javac -d . xxx.java

// ����ļ�����ִ��,��ָ��classpath 
// java -cp ./ a.a1.A


class A{
	public static void main(String[] args){
		System.out.println("Hello package");
		Date d = new Date();
		System.out.println(d);
	}
}
