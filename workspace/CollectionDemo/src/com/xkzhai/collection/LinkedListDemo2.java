package com.xkzhai.collection;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class LinkedListDemo2 {

	public static void main(String[] args) {
		test1();
		test12();
	}
	
	public static void test1(){
		long l = System.currentTimeMillis();
		try{
			List<byte[]> list = new LinkedList<byte[]>();
			//List<byte[]> list = new ArrayList<byte[]>();
			
			//List<Integer> list = new LinkedList<Integer>();
			int i = 0;
			boolean b = true;
			while(b){
				// list.add(i++);
				list.add(new byte[10*1024]);
				// System.out.println(i);
//				try {
//					Thread.sleep(1);
//				} catch (InterruptedException e) {
//					e.printStackTrace();
//				}
			}
		}
		catch(Exception e){
			
		}
		finally{
			System.out.println("Array: "+(System.currentTimeMillis() - l));
		}
	}
	
	public static void test12(){
		long l = System.currentTimeMillis();
		try{
			List<byte[]> list = new LinkedList<byte[]>();
			//List<byte[]> list = new ArrayList<byte[]>();
			
			//List<Integer> list = new LinkedList<Integer>();
			int i = 0;
			boolean b = true;
			while(b){
				// list.add(i++);
				list.add(new byte[10*1024]);
				// System.out.println(i);
//				try {
//					Thread.sleep(1);
//				} catch (InterruptedException e) {
//					e.printStackTrace();
//				}
			}
		}
		catch(Exception e){
			
		}
		finally{
			System.out.println("Linked: "+(System.currentTimeMillis() - l));
		}
	}
}
