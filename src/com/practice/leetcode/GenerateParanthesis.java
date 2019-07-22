package com.practice.leetcode;

import java.util.LinkedList;
import java.util.List;

public class GenerateParanthesis {
	List<String> list = new LinkedList<>();

	public List<String> generateParenthesis(int n) {
		String str = "(";
		paranthesisHelper(str, 1, n);

		return list;
	}

	/**
	 * recursive method 
	 * @param str
	 * @param index
	 * @param n
	 */
	private void paranthesisHelper(String str, int index, int n) {
		if (index >= n * 2) {
			if (isValid(str)) {
				list.add(str);
			}
			return;
		} else {
			paranthesisHelper(str + "(", index + 1, n);
			paranthesisHelper(str + ")", index + 1, n);
		}
	}

	public boolean isValid(String s) {
		int count = 0;
		for (int i = 0; i < s.length(); i++) {
			char ch = s.charAt(i);
			if (ch == '(') {
				count++;
			} else {
				count--;
			}
			if (count < 0)
				return false;
		}
		return count == 0;

	}

}
