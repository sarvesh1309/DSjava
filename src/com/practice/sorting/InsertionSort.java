package com.practice.sorting;

public class InsertionSort {
	/**
	 * after each kth iteration first k element would be sorted
	 * 
	 * @param input
	 * @return
	 */
	public int[] insertionSort(int[] input) {
		for (int i = 1; i < input.length; i++) {
			int j = i;
			int curr = input[i];
			// compare the curr value with the previous value in array 
			while (j > 0 && input[j - 1] > curr) {
				input[j] = input[j - 1];
				j--;
			}
			// insert the curr value at the correct position in array
			input[j] = curr;
		}

		return input;
	}

}
