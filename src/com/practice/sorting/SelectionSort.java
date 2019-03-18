package com.practice.sorting;

public class SelectionSort {

	/**
	 * find the min value in array and replace it at the ith place where i the
	 * the loop number
	 * 
	 * @param input
	 * @return
	 */
	public int[] selectionSort(int[] input) {
		for (int i = 0; i < input.length; i++) {
			int minIndex = findMin(i, input);
			//after each iteration below swap will make sure to put the min value of array at the ith position 
			swap(i, minIndex, input);
		}
		return input;
	}

	/**
	 * find the min index in array staring from given index point
	 * 
	 * @param startIndex
	 * @param input
	 * @return
	 */
	private int findMin(int startIndex, int[] input) {
		int minIndex = startIndex;
		for (int i = startIndex; i < input.length; i++) {
			if (input[minIndex] > input[i]) {
				minIndex = i;
			}
		}
		return minIndex;

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
