package com.practice.leetcode;

/**
 * leetcode 12
 * @author sarveshkumar
 *
 */
public class IntToRoman {

	public String intToRoman(int num) {
		String[] roman = { "I", "IV", "V", "IX", "X", "XL", "L", "XC", "C", "CD", "D", "CM", "M" };
		int[] values = { 1, 4, 5, 9, 10, 40, 50, 90, 100, 400, 500, 900, 1000 };
		String result = "";

		for (int i = values.length - 1; i >= 0 && num != 0; i--) {
			while (num >= values[i]) {
				num -= values[i];
				result += roman[i];
			}
		}
		return result;
	}
}
