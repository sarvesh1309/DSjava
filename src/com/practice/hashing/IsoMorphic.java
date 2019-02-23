package com.practice.hashing;

import java.util.HashMap;
import java.util.Map;

public class IsoMorphic {
	   public boolean isIsomorphic(String s, String t) {
	        Map<Character, Character> map = new HashMap<Character,Character>();
	       int length = s.length();
	       for(int i=0;i<length;i++) {
	            char temp = s.charAt(i);
	            if(map.containsKey(temp)){
	               if(t.charAt(i)!=map.get(temp)) {
	            	   return false;
	               }
	            }else{
	            if(map.containsValue(t.charAt(i))) {
	            	return false;
	            }
	                map.put(temp,t.charAt(i));
	            }
	        }
	       return true;
	    }

}
