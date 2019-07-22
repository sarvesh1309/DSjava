package com.practice.dynamicprogramming;

public class LongestSubsequenceOfString {

	public void PrintLCS(String str1, String str2) {
		int[][] mem = new int[str1.length()+1][str2.length()+1];
		for (int i = 0; i < str1.length(); i++) {
			for (int j = 0; j < str2.length(); j++) {
				mem[i][j] = -1;
			}
		}
		int length = LCS(str1.toCharArray(), 0, str2.toCharArray(), 0, mem);
		System.out.println(length);

	}

	private int LCS(char[] charArray, int i, char[] charArray2, int j, int[][] mem) {
		if (i == charArray.length || j == charArray2.length) {
			return 0;
		} else if (charArray[i] == charArray2[j]) {
			if (i<charArray.length && j<charArray2.length && mem[i + 1][j + 1] == -1) {
				mem[i + 1][j + 1] = LCS(charArray, i + 1, charArray2, j + 1, mem);
			}
			return 1 + mem[i + 1][j + 1];
		} else {
			if (i<charArray.length && j<charArray2.length && mem[i][j + 1] == -1) {
				mem[i][j + 1] = LCS(charArray, i, charArray2, j + 1, mem);
			}
			if (i<charArray.length && j<charArray2.length && mem[i + 1][j] == -1) {
				mem[i + 1][j] = LCS(charArray, i+1, charArray2, j , mem);
			}
			return Math.max(mem[i][j + 1], mem[i + 1][j]);
		}
	}

}
