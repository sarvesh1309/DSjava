package com.practice.string;

public class StringOperation {

	/**
	 * use xor operation for swap operation without using tmp variable
	 * 
	 * @param input
	 * @return
	 */
	public String reverseString(String input) {
		int end = input.length() - 1;
		int start = 0;
		char ch[] = input.toCharArray();
		while (start < end) {
			ch[start] = (char) (ch[start] ^ ch[end]);
			ch[end] = (char) (ch[end] ^ ch[start]);
			ch[start] = (char) (ch[end] ^ ch[start]);
			start++;
			end--;
		}
		return String.valueOf(ch);

	}

	
}
