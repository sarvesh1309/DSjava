package com.practice.leetcode;

public class Solution {
	public int isMatch(final String A, final String B) {

		int[][] mem = new int[A.length()+1][B.length()+1];
		for (int i = 0; i <= A.length(); i++) {
			for (int j = 0; j <= B.length(); j++) {
				mem[i][j] = -1;
			}
		}
		return helper(A, 0, B, 0, mem);

	}

	public int helper(String A, int indexa, String B, int indexb, int[][] mem) {
		System.out.println("indexa " + indexa + "indexb " + indexb);
		if (mem[indexa][indexb] != -1)
			return mem[indexa][indexb];
		if (indexb == B.length()) {
			mem[indexa][indexb] = (indexa == A.length() ? 1 : 0);
		} else {

			boolean isFirstCharMatch = false;
			char ch = B.charAt(indexb);
			if (indexa != A.length() && (ch == '?' || A.charAt(indexa) == ch)) {
				isFirstCharMatch = true;
			}

			if (ch == '*') {
				if ((indexa != A.length() && (helper(A, indexa + 1, B, indexb, mem)) == 1)
						|| helper(A, indexa, B, indexb + 1, mem) == 1) {
					mem[indexa][indexb] = 1;
				} else {
					mem[indexa][indexb] = 0;
				}
			} else {
				if (isFirstCharMatch) {
					mem[indexa][indexb] = helper(A, indexa + 1, B, indexb + 1, mem);
				} else {
					mem[indexa][indexb] = 0;
				}
			}
		}
		return mem[indexa][indexb];

	}
}