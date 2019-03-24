package com.practice.sorting;

public class KwayMergeSorted {

	// number of item in array
	int n = 0;

	/**
	 * input array contains k array of
	 * 
	 * @param input
	 * @return
	 */

	public int[] sort(int[][] input) {
		if (input == null) {
			return null;
		}
		if (input.length == 1) {
			return input[0];
		}
		n = input[0].length;
		int[] output = new int[input.length * n];
		kwaymergeSort(input, 0, input.length - 1, output);
		return output;

	}

	/**
	 * 
	 * @param input
	 * @param leftArray
	 * @param righArray
	 * @return
	 */
	private void kwaymergeSort(int[][] input, int leftArray, int righArray, int[] output) {
		// add items in output array
		if (leftArray == righArray) {
			for (int i = 0; i < n; i++) {
				output[(n * leftArray) + i] = input[leftArray][i];
			}
		}
		if (righArray > leftArray) {
			int mid = (righArray + leftArray) / 2;
			// divided the input array 
			kwaymergeSort(input, leftArray, mid, output);
			kwaymergeSort(input, mid + 1, righArray, output);
			// merge the array 
			mergeTwoArray(leftArray, mid, righArray, output);
		}
	}

	/**
	 * 
	 * @param left
	 * @param mid
	 * @param right
	 * @param output
	 */
	private void mergeTwoArray(int left, int mid, int right, int[] output) {
		int leftArrayStart = left * n;
		int rightArrayStart = (mid + 1) * n;

		int leftSize = (mid - left + 1) * n;
		int rightArraySize = (right - mid) * n;

		int leftArray[] = new int[leftSize];
		int rightArray[] = new int[rightArraySize];
		int k = leftArrayStart;
		// build tmp left array
		for (int i = 0; i < leftSize; i++) {
			leftArray[i] = output[leftArrayStart];
			leftArrayStart++;
		}
		// build tmp right array
		for (int i = 0; i < rightArraySize; i++) {
			rightArray[i] = output[rightArrayStart];
			rightArrayStart++;
		}

		int i = 0, j = 0;
		// short the left and right tmp array and add sorted item in output array
		while (i < leftSize && j < rightArraySize) {
			if (leftArray[i] < rightArray[j]) {
				output[k] = leftArray[i];
				i++;
			} else {
				output[k] = rightArray[j];
				j++;
			}
			k++;
		}
		while (i != leftArray.length) {
			output[k] = leftArray[i];
			i++;
			k++;
		}
		while (j != rightArray.length) {
			output[k] = rightArray[j];
			j++;
			k++;
		}

	}

}
