package com.xkzhai.socket;

import java.io.IOException;
import java.net.ServerSocket;

public class ServerSocketDemo {

	public static void main(String[] args) throws Exception {
		// ����ServerSocket����
		ServerSocket ss = new ServerSocket(0);
		System.out.println(ss.getLocalPort());
		// ����
		ss.accept();
		System.out.println("over");
	}

}
