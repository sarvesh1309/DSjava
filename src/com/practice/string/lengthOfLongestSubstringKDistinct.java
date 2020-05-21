package com.practice.string;

import java.util.HashSet;
import java.util.Set;

public class lengthOfLongestSubstringKDistinct {
	
	
	 /**
     * @param s: A string
     * @param k: An integer
     * @return: An integer
     */
    public int lengthOfLongestSubstringKDistinctBruteForce(String s, int k) {
       int maxLen = 0;
       Set<Character> set = null;
       for(int i =0;i<s.length();i++){
           set = new HashSet<>();
           set.add(s.charAt(i));
           for(int j =i; j<s.length();j++){
               set.add(s.charAt(j));
               if(set.size()>k){
                   break;
               }
               maxLen = Math.max(maxLen,j-i+1);
           }
       }
       
       return maxLen;
       
    }

}
