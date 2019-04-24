package com.practice.leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LongestSubStringWithourRepeatChar {
	
	/**
	 * use the concept of string substring method . 
	 * Complexity would be O(n^2) as substring would also take O(n) complexity in worst time
	 * @param s
	 * @return
	 */
	public int lengthOfLongestSubstring(String s) {
		if (s == null || s.length() == 0) {
			return 0;
		}
		String subset = "";
		int max = 0;
		int result = 0;

		for (int i = 0; i < s.length(); i++) {
			if (subset.indexOf(s.charAt(i)) == -1) {
				subset += s.charAt(i);
				max++;
			} else {
				int index = subset.indexOf(s.charAt(i));
				subset = subset.substring(index + 1);
				// add the current char at last
				subset += s.charAt(i);
				max = max - index;
			}
			if (max > result) {
				result = max;
			}
		}

		return result;

	}

	/**
	 * using sliding window concept
	 * @param s
	 * @return
	 */
	public int lengthOfLongestSubstringSlindingWindow(String s) {
		if (s.length() <= 1) {
			return s.length();
		}
		// hash set to contains the visited char
		Set<Character> set = new HashSet<>();
		int left = 0;
		int right = 0;
		int max = 0;
		String maxString = "";
		// iterate until right slide of window reaches the end of string and
		// processed all string
		while (right != s.length()) {
			// current char
			char ch = s.charAt(right);
			// if set does not contains the char then add it to visited set ,
			// slide the right index of window , and calculate the max of window
			// width
			if (!set.contains(ch)) {
				set.add(ch);
				if ((right - left + 1) > max) {
					max = right - left + 1;
					maxString = s.substring(left, right + 1);
				}

				right++;
				// if the current char contains in the visited set then slide
				// the left window and remove the current char from visited set
			} else {
				set.remove(s.charAt(left));
				left++;
			}
			// if current width is greater than result then result is max width
		}
		System.out.println("max lenght string = :" + maxString);

		return max;

	}
	
	/**
	 * optimizing of sliding window concept. Instead of moving left pointer step by step move it to the right of repeated char
	 * @param s
	 * @return
	 */
	 public int lengthOfLongestSubstringWindownOptimized(String s) {
	        int n = s.length(), ans = 0;
	     // current index of character
	        Map<Character, Integer> map = new HashMap<>(); 
	        // try to extend the range [i, j]
	        for (int right = 0, left = 0; right < n; right++) {
	        	// if char exist in map then move the left pointer of next index of string 
	            if (map.containsKey(s.charAt(right))) {
	            	// left would point to max of existing left point and the (position of char in the map + 1) . +1 to get the position of next index in string .
	                left = Math.max((map.get(s.charAt(right))+1), left);
	                
	            }
	            map.put(s.charAt(right), right);
	            ans = Math.max(ans, right - left+1);
	            
	        }
	        return ans;
	    }

}
