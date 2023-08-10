package com.xkzhai.collection;

import java.util.ArrayList;
import java.util.List;

public class PersonForTS {
	private int height;
	private List<String> tels = new ArrayList<String>();

	public int getHeight() {
		return height;
	}

	public List<String> getTels() {
		return tels;
	}

	public void setTels(List<String> tels) {
		this.tels = tels;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public PersonForTS(int height) {
		super();
		this.height = height;
	}
	
	// 变长参数
	public void addTel(String... str){
		//tels.add(str);
		for(String s: str){
			tels.add(s);
		}
	}
	// 变长参数必须是方法的最后一个参数
//	public void addTel(String... str,String ii){
//		//tels.add(str);
//		for(String s: str){
//			tels.add(s);
//		}
//	}
	
}
