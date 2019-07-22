package com.practice.leetcode;

import java.util.LinkedList;
import java.util.List;

public class LetterCombinationsPhoneNumber {
	List<String> rtn;
	

	public List<String> letterCombinations(String digits) {
		rtn = new LinkedList<>();
		String[] inputstr = { "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz" };
		String[] comb = new String[digits.length()];
		for (int i = 0; i < digits.length(); i++) {
			int digit = digits.charAt(i) - '0';
			String digitString = inputstr[digit - 2];
			comb[i] = digitString;
		}
		StringBuilder sb = new StringBuilder();
		recursion(comb, sb);
		return rtn;

	}

	private void recursion(String[] textList, StringBuilder track) {
		if (track.length() == textList.length) {
			rtn.add(track.toString());
			return;
		}

		int row = track.length();
		for (int i = 0; i < textList[row].length(); i++) {
			track.append(textList[row].charAt(i));
			recursion(textList, track);
			track.deleteCharAt(track.length() - 1);
		}
	}

}
