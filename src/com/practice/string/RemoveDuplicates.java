package com.practice.string;

public class RemoveDuplicates {

	public String removeDup(String str) {
		StringBuilder str1 = new StringBuilder();
		for (int i = 1; i < str.length(); i++) {
			char ch = str.charAt(i);
			if (ch != str1.charAt(str1.length() - 1)) {
				str1.append(ch);
			}
		}
		return str1.toString();
	}

	/**
	 * recursive method
	 * 
	 * @param str
	 * @param newstr
	 * @param i
	 * @param j
	 * @return
	 */
	private String removeDupRec(String str, String newstr, int i, int j) {
		if (j == str.length()) {
			return newstr;
		} else {
			if (newstr.charAt(i) == str.charAt(j)) {
				return removeDupRec(str, newstr, i, j+1);
			} else {
				return removeDupRec(str, newstr + str.charAt(j), i+1, j+1);
			}
		}
	}

	public String removeDupRec(String str) {
		return removeDupRec(str, String.valueOf(str.charAt(0)), 0, 1);
	}

}
