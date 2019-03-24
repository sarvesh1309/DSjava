package com.practice.sorting;

public class MergeSort {
	/**
	 * devide array into smaller pieces . sort smallper piece and merge them
	 * back in sorted order
	 * 
	 * @param input
	 * @return
	 */
	public int[] mergeSort(int[] input) {
		if (input.length < 2) {
			System.out.println("already sorted");
			return input;
		}
		mergeSorthelper(input, 0, input.length - 1);
		return input;

	}

	private void mergeSorthelper(int[] input, int start, int end) {
		if (end > start) {
			int pivot = (start+end)/2;
			mergeSorthelper(input, start, pivot);
			mergeSorthelper(input, pivot + 1, end);
			mergeTwoSortedArray(input, start, pivot, end);
		}

	}

	/**
	 * 
	 * @param input
	 * @param left
	 * @param pivot
	 * @param right
	 */
	private void mergeTwoSortedArray(int[] input, int left, int pivot, int right) {
		int leftArrSize = pivot - left + 1;
		int[] leftArray = new int[leftArrSize];

		int rightArrSize = right - pivot;
		int[] rightArray = new int[rightArrSize];

		int j = 0;
		for (int i = left; i <= pivot; i++) {
			leftArray[j] = input[i];
			j++;
		}
		j = 0;
		for (int i = pivot + 1; i <= right; i++) {
			rightArray[j] = input[i];
			j++;
		}
		mergeTwoSortedArray(input, leftArray, rightArray, left);

	}

	/**
	 * 
	 * @param array1
	 * @param array2
	 * @return
	 */
	private void mergeTwoSortedArray(int[] input, int[] array1, int[] array2, int start) {
		int i = 0, j = 0, k = start;
		while (i < array1.length && j < array2.length) {
			if (array1[i] < array2[j]) {
				input[k] = array1[i];
				i++;
			} else {
				input[k] = array2[j];
				j++;
			}
			k++;
		}
		while (i != array1.length) {
			input[k] = array1[i];
			i++;
			k++;
		}
		while (j != array2.length) {
			input[k] = array2[j];
			j++;
			k++;
		}
	}

}
