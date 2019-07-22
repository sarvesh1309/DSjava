package com.practice.leetcode;

public class LongestSub {

	/**
	 * 
	 * @param s
	 * @return
	 */
	public String longestPalindromeMonacher(String s) {
		// new string with new $ char to handle even char
		int len = s.length();
		char newstring[] = new char[2 * len + 1];
		int palindrome[] = new int[2 * len + 1];
		int i = 0, j = 0;
		newstring[i++] = '$';
		while (i < newstring.length) {
			newstring[i++] = s.charAt(j++);
			newstring[i++] = '$';
		}

		int center = 0;
		int right = 0;
		int mirror = 0;
		palindrome[0] = 0;
		int maxPalLength = 0;
		int maxPalCenter = 0;
		// i is each char in new string
		for (i = 1; i < newstring.length; i++) {
			// left mirror of current char
			mirror = 2 * center - i;
			int diff = right - i;
			// currentright position lies within the center right position
			if (diff > 0) {
				palindrome[i] = Math.min(palindrome[mirror], diff);
			}
			// expand
			while (((i + palindrome[i]) < newstring.length - 1 && (i - palindrome[i]) > 0)
					&& newstring[i + (1 + palindrome[i])] == newstring[i - (1 + palindrome[i])]) {
				palindrome[i]++;
			}

			if (i + palindrome[i] > right) {
				center = i;
				right = 1 + palindrome[i];
			}
			if (palindrome[i] > maxPalLength) {
				maxPalLength = palindrome[i];
				maxPalCenter = i;
			}

		}

		int start = (maxPalCenter - maxPalLength) / 2;
		int end = start + maxPalLength - 1;
		System.out.println("start +"+start +"end "+end);
		return s.substring(start, end + 1);

	}

	/**
	 * 
	 * @param s
	 * @return
	 */
	public String longestPalindrome(String s) {
		int len = s.length();
		boolean[][] table = new boolean[len][len];
		int start = 0;
		int palLength = 0;
		// for length 1 all string would be palindrome
		for (int i = 0; i < len; i++) {
			table[i][i] = true;
			start = i;
			palLength = 1;
		}
		// for length =2
		for (int i = 0; i < len - 1; i++) {
			if (s.charAt(i) == s.charAt(i + 1)) {
				table[i][i + 1] = true;
				start = i;
				palLength = 2;
			}
		}

		// for all string length >2
		for (int k = 3; k <= len; k++) {
			for (int i = 0; i < len - k + 1; i++) {
				// end index for string that start at i and have length k
				int j = i + k - 1;
				// if str at i and j are equal and table is true then it is an
				// palindrome
				if (s.charAt(i) == (s.charAt(j)) && table[i + 1][j - 1]) {
					table[i][j] = true;
					start = i;
					palLength = k;
				}
			}
		}

		return s.substring(start, (start + palLength));

	}

	/**
	 * brute force iteration
	 * 
	 * @param s
	 * @return
	 */
	public String longestPalindromeBruteIter(String s) {
		String palin = "";
		for (int i = 0; i < s.length(); i++) {
			for (int j = i + 1; j <= s.length(); j++) {
				// if string and it's reverse is same then it is an palindrome
				String str = s.substring(i, j);
				String rev = reverseString(str);
				// it string is an palindrome then compare the size with the
				// pre-calculated palindrome
				if (str.equals(rev)) {
					if (str.length() > palin.length()) {
						palin = str;
					}
				}

			}
		}
		return palin;

	}

	public String reverseString(String s) {
		char ch[] = s.toCharArray();
		int len = ch.length;
		for (int i = 0; i < len / 2; i++) {
			char tmp = ch[i];
			ch[i] = ch[len - 1 - i];
			ch[len - 1 - i] = tmp;
		}
		return String.valueOf(ch);
	}

}
