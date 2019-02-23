package com.practice.others;

import java.util.Arrays;
import java.util.HashMap;

public class sumTarget {
  public static void main(String s[]) {
	  int val[] = sum(new int[]{2,5,5,11}, 10);
	  System.out.println(Arrays.toString(val));
	
}
  public static int[] sum(int num[],int target) {
	  HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
	  for(int i=0;i<num.length;i++) {
		  int diff = target -num[i];
		  if(map.containsKey(diff)) {
			  return new int[]{map.get(diff),i};
		  }else {
			  map.put(num[i], i);
		  }
	  }
	  return null;
  }

}
