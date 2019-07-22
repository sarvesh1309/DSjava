package com.practice.dynamicprogramming;

public class UglyNumbers {

	/**
	 * 
	 * @param n
	 * @return
	 */
	public int findUglyNumber(int n) {
		if (n == 1) {
			return 1;
		} else {
			int count = 1;
			int temp = 2;
			while (count != n) {
				// if i has having only 2,3 and 5 prime factor then increment
				// count by 1
				int i = temp;
				while (i % 2 == 0) {
					i = i / 2;
				}
				while (i % 3 == 0) {
					i = i / 3;
				}
				while (i % 5 == 0) {
					i = i / 5;
				}
				if (i == 1) {
					count++;
				}
				temp++;
			}
			return (temp - 1);
		}

	}

	/**
	 * for each loop ugly number would be min of 2*i,3*i,5*i
	 * 
	 * @param n
	 * @return
	 */
	public int findUglyNumberDynamic(int n) {
		int[] ugly = new int[n];
		ugly[0] = 1;
		int i2 = 0, i3 = 0, i5 = 0;
		for (int i = 1; i < n; i++) {
			ugly[i] = Math.min(ugly[i2] * 2, Math.min(ugly[i3] * 3, ugly[i5] * 5));
			if (ugly[i] == ugly[i2] * 2) {
				i2 += 1;
			}
			if (ugly[i] == ugly[i3] * 3) {
				i3 += 1;
			}
			if (ugly[i] == ugly[i5] * 5) {
				i5 += 1;
			}
		}
		return ugly[n - 1];
	}
}
