package com.xkzhai.collection;

import java.util.Comparator;

public class PersonForTSComparator implements Comparator<PersonForTS>{
	@Override
	public int compare(PersonForTS o1, PersonForTS o2) {
		if(o1==null){
			if(o2==null){
				return 0;
			}
			return -1;
		}
		else{
			if(o2==null){
				return 1;
			}
			return o1.getHeight() - o2.getHeight();
		}
	}
}
