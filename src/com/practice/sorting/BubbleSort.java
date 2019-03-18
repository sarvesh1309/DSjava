package com.practice.sorting;

public class BubbleSort {

	/**
	 * compare ith element with i+1th element
	 * 
	 * @param input
	 * @return
	 */
	public int[] bubbleSort(int[] input) {
		boolean isSorted = false;
		// add flag isSorted for condition where array is already sorted and
		// requires no more comparison
		for (int i = input.length - 1; ((i > 0) && (!isSorted)); i--) {
			isSorted = true;
			for (int j = 0; j <= i-1 ; j++) {
				if (input[j] > input[j + 1]) {
					swap(j, j + 1, input);
					isSorted = false;
				}
			}
		}

		return input;

	}

	/**
	 * swap two elements
	 * 
	 * @param i
	 * @param j
	 * @param input
	 */
	private void swap(int i, int j, int[] input) {
		int tmp = input[i];
		input[i] = input[j];
		input[j] = tmp;
	}

}
