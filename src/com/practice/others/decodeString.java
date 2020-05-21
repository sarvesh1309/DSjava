package com.practice.others;

public class decodeString {

	public static int numays(String data) {
		int[] memo = new int[data.length() + 1];
		for (int i = 0; i <= data.length(); i++) {
			memo[i] = -1;
		}
		return helper(data, data.length(), memo);
	}

	public static int helper(String data, int k, int[] memo) {
		if (k == 0)
			return 1;
		if (data.charAt(data.length() - k) == '0')
			return 0;
		if (memo[k] != -1)
			return memo[k];

		if (k > 1 && Integer.parseInt(data.substring(data.length() - k, data.length() - k + 2)) <= 26) {
			memo[k] = helper(data, k - 1, memo) + helper(data, k - 2, memo);
		} else {
			memo[k] = helper(data, k - 1, memo);
		}

		return memo[k];

	}

}
