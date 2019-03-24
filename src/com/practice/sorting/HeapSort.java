package com.practice.sorting;

public class HeapSort {

	/**
	 * O(nlogn)
	 * @param input
	 * @return
	 */
	public int[] heapSort(int[] input) {

		// build max heap for input array this takes O(n)
		buildHeap(input);
		// replace the first element which would be the max element of array
		// with the first element of heap array
		for (int i = input.length - 1; i >= 0; i--) {
			// swap first element with the last elem
			swap(i, 0, input);

			// heapify the heap barring the last element of heap array
			heapifyDown(input, 0, i);
		}

		return input;

	}

	/**
	 * build a max heap
	 * 
	 * @param input
	 */
	private void buildHeap(int[] input) {
		int n = input.length;
		for (int i = (n - 1) / 2; i >= 0; i--) {
			heapifyDown(input, i, n);
		}

	}

	/**
	 * 
	 * @param input
	 * @param i
	 * @param length
	 */
	private void heapifyDown(int[] input, int i, int length) {
		int left = (2 * i + 1) >= length ? -1 : (2 * i + 1);
		int right = (2 * i + 2) >= length ? -1 : (2 * i + 2);

		int max = i;
		if (left != -1 && input[max] < input[left]) {
			max = left;
		}
		if (right != -1 && input[max] < input[right]) {
			max = right;
		}
		if (max != i) {
			swap(max, i, input);
			heapifyDown(input, max, length);
		}

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
