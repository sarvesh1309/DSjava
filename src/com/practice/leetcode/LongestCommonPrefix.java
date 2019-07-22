package com.practice.leetcode;

public class LongestCommonPrefix {
	
	public String longestCommonPrefix(String[] strs) {
        if(strs == null || strs.length == 0) return "";
        StringBuilder sb = new StringBuilder(strs[0]);
        for(int i = 1; i < strs.length; i++) {
            while(strs[i].indexOf(sb.toString())!=0) {
                sb.deleteCharAt(sb.length()-1);
                if(sb.length() == 0) return "";
            }
        }
        return sb.toString();
    }

	public String longestCommonPrefixALT2(String[] strs) {
		if (strs == null || strs.length == 0) {
			return "";
		}
		if (strs.length == 1) {
			return strs[0];
		}
		String str = "";

		int match = 0;
		while (true) {
			char first;
			if (match < strs[0].length()) {
				first = strs[0].charAt(match);
			} else {
				break;
			}
			for (int i = 1; i < strs.length; i++) {
				if (match == strs[i].length()) {
					return str;
				} else if (first != strs[i].charAt(match)) {
					return str;
				}
			}
			match++;
			str += first;
		}
		return str;

	}

	public String longestCommonPrefixAlt(String[] strs) {
		if (strs == null || strs.length == 0) {
			return "";
		}
		if (strs.length == 1) {
			return strs[0];
		}
		String str = "";
		int minlength = Integer.MAX_VALUE;
		int index = 0;
		for (int i = 0; i < strs.length; i++) {
			if (strs[i].length() < minlength) {
				minlength = strs[i].length();
				index = i;
			}
		}

		for (int j = 0; j < minlength; j++) {
			char ch = strs[index].charAt(j);
			for (int k = 0; k < strs.length; k++) {
				if (ch != strs[k].charAt(j)) {
					return str;
				}
			}
			str += ch;
		}

		return str;

	}
}
