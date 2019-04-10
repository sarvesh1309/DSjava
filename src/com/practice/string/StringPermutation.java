package com.practice.string;

public class StringPermutation {

	/**
	 * input string it respects the duplicate char in string . e.g 'aaa' would
	 * have output aaa only
	 * 
	 * @param input
	 */
	public void permutationInOrder(String input) {
		permutationInOrderHelper("", input);
	}

	/**
	 * 
	 * @param str
	 * @param input
	 */
	private void permutationInOrderHelper(String str, String input) {
		int len = input.length();
		if (input.length() == 0) {
			System.out.println(str);
		} else {
			boolean temp[] = new boolean[26];
			for (int i = 0; i < input.length(); i++) {
				char ch = input.charAt(i);
				// rest of string bar fixed char
				String ros = input.substring(0, i) + input.substring(i + 1, len);
				if (!temp[ch - 'a']) {
					// string without the charat(i) would be input string as
					// charAt(i) is now prefix has been fixed
					permutationInOrderHelper(str + ch, ros);
				}
				temp[ch - 'a'] = true;
			}
		}

	}

	/**
	 * input string it does not take duplicate char in consideration while
	 * printing outout string e,g 'aaa' would still print 6 permutation string
	 * value whic are all same 'aaa'
	 * 
	 * @param input
	 */
	public void permutationNotInOrder(String input) {
		char ch[] = input.toCharArray();
		permutationNotInOrder(ch, 0);
	}

	private void permutationNotInOrder(char[] ch, int left) {
		// if left is equal to right then it means no char has left to permute
		// so print the string
		if (left == ch.length) {
			System.out.println(String.valueOf(ch));
			return;
		}
		for (int i = left; i < ch.length; i++) {
			// fix the left position
			swap(ch, left, i);
			// permute others character in string
			permutationNotInOrder(ch, (left + 1));
			// swap again to restore the original char
			swap(ch, left, i);

		}

	}

	/**
	 * 
	 * @param ch
	 * @param i
	 * @param j
	 */
	private void swap(char[] ch, int i, int j) {
		char temp = ch[i];
		ch[i] = ch[j];
		ch[j] = temp;

	}

}
