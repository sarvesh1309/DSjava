package com.practice.sorting;

public class CountSort {

	public int[] sort(int[] input) {
		// Aux array
		int k[] = new int[2000000];
		// sorted array
		int sorted[] = new int[input.length];
		// update the aux array with the counting of occurrences in input array
		for (int i = 0; i < input.length; i++) {
			k[input[i]] = k[input[i]] + 1;
		}

		// find the position of each element
		for (int i = 1; i < k.length; i++) {
			k[i] = k[i] + k[i - 1];
		}

		// traverse in reverse order to make it stable
		for (int i = input.length - 1; i >= 0; i--) {
			sorted[k[input[i]] - 1] = input[i];
			k[input[i]] = k[input[i]] - 1;
		}

		return sorted;
	}

}
