package com.practice.leetcode;

/**
 * leetcode - 10
 * @author sarveshkumar
 *
 */
public class RegularExpression {

	public boolean isMatch(String text, String pattern) {
		if (pattern.isEmpty())
			return text.isEmpty();
		boolean first_match = (!text.isEmpty() && (pattern.charAt(0) == text.charAt(0) || pattern.charAt(0) == '.'));

		if (pattern.length() >= 2 && pattern.charAt(1) == '*') {
			return (isMatch(text, pattern.substring(2)) || (first_match && isMatch(text.substring(1), pattern)));
		} else {
			return first_match && isMatch(text.substring(1), pattern.substring(1));
		}
	}

	public boolean isMatchDP(String text, String pattern) {
		Result[][] table = new Result[text.length() + 1][pattern.length() + 1];
		return DP(0, 0, text, pattern, table);
	}

	enum Result {
		TRUE, FALSE
	}

	private boolean DP(int i, int j, String text, String pattern, Result[][] table) {
		if (table[i][j] != null) {
			return table[i][j] == Result.TRUE;
		}
		boolean ans;
		if (j == pattern.length()) {
			ans = (i == text.length());
		} else {
			boolean first_match = (i < text.length()
					&& (pattern.charAt(j) == text.charAt(i) || pattern.charAt(j) == '.'));
			if (pattern.length() > j + 1 && pattern.charAt(j + 1) == '*') {
				ans = (DP(i, j + 2, text, pattern, table) || (first_match && DP(i + 1, j, text, pattern, table)));
			} else {
				ans = first_match && DP(i + 1, j + 1, text, pattern, table);
			}
		}

		table[i][j] = ans ? Result.TRUE : Result.FALSE;

		return ans;

	}

}
