package com.xkzhai.collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class CollectionToolDemo {

	public static void main(String[] args) {
		int[] src = {1,2,3,4};
		int[] dest = new int[6];
		System.arraycopy(src, 1, dest, 2, 3);
		
		for(int i: dest){
			System.out.println(i);
		}
		
		System.out.println("-------");
		PersonForTS[] src0 = {new PersonForTS(100),new PersonForTS(200),new PersonForTS(300),new PersonForTS(400)};
		PersonForTS[] dest0 = new PersonForTS[6];
		System.arraycopy(src0, 1, dest0, 2, 3);
		
		src[1] = 1000;
		System.out.println(dest[2]);
		
		src0[1].setHeight(1000);
		System.out.println(dest0[2].getHeight());
		
		// 得到同步集合
		List<String> names = Collections.synchronizedList(new ArrayList<String>());
		names.add("tom");
		names.add("tom");
		names.add("tom");
		names.add("tom");
		System.out.println(names.size());
		
		// 最大值/最小值
		// Collections.max() Collections.min();
		
		
		// Arrays asList将参数转换成Array$ArrayList对象
		List list = Arrays.asList(1,2,3,4);
		System.out.println(list.size());
		
		
	}

}
