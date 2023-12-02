package com.xkzhai.socket;

import java.io.IOException;
import java.net.ServerSocket;

public class ServerSocketDemo {

	public static void main(String[] args) throws Exception {
		// 创建ServerSocket对象
		ServerSocket ss = new ServerSocket(0);
		System.out.println(ss.getLocalPort());
		// 接收
		ss.accept();
		System.out.println("over");
	}

}
