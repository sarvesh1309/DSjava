package com.practice.string;

import java.util.HashMap;
import java.util.Map;

/**
 * this class implements using brute force which utilizes Hashing  -Time complexity O(n^2)
 * Another way is Suffix tree - O(n) - Complicated algorithm
 * another way would be dynamic programming - which would be implemented in dynamic programming chapter
 * @author sarveshkumar
 *
 */
public class FindBiggestSubstring {

	/**
	 * 
	 * @param str1
	 * @param str2
	 * @return
	 */
	public String getLongestCommonString(String str1, String str2) {
		Map<String, Integer> set1 = new HashMap<>();
		Map<String, Integer> set2 = new HashMap<>();
		// build the map which contains the all possible substring for given string str1 and its length
		for (int i = 0; i < str1.length(); i++) {
			String temp = "";
			addPossibleString(str1, i, set1, temp);
		}
		// build the map which contains the all possible substring for given string str2 and its length
		for (int i = 0; i < str2.length(); i++) {
			String temp = "";
			addPossibleString(str2, i, set2, temp);
		}

		int max = 0;
		String maxSubstring = "";
		// iterate over one of the map and find the common element from both map which has highest value of length
		for (String st : set1.keySet()) {
			if (set2.containsKey(st)) {
				if (set2.get(st) > max) {
					max = set2.get(st);
					maxSubstring = st;
				}
			}
		}
		return maxSubstring;
	}

	private void addPossibleString(String str, int i, Map<String, Integer> set, String temp) {
		if (i < str.length()) {
			temp = temp + str.charAt(i);
			set.put(temp, temp.length());
			addPossibleString(str, (i + 1), set, temp);
		}
	}

}
