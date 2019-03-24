package com.practice.sorting;

public class QuickSort {

	/**
	 * 
	 * @param input
	 * @return
	 */
	public int[] quickSort(int[] input) {
		int low = 0;
		int high = input.length - 1;
		quickSortHelper(input, low, high);
		return input;

	}

	/**
	 * 
	 * @param input
	 * @param low
	 * @param high
	 */
	private void quickSortHelper(int[] input, int low, int high) {
		if (high > low) {
			// find partition point
			int pivot = partitionLeft(input, low, high);
			quickSortHelper(input, low, pivot - 1);
			quickSortHelper(input, pivot + 1, high);
		}

	}
	
	/**
	 * 
	 * @param input
	 * @param low
	 * @param high
	 * @return
	 */
	private int partitionMiddle(int[] input, int low, int high) {
		int pivot = input[low+(high-low)/2];
		int p = low;
		int q = high;
		while (q > p) {
			while (p <= high && input[p] <= pivot) {
				p++;
			}
			while (q >= low && input[q] > pivot) {
				q--;
			}
			if (q > p) {
				swap(p, q, input);
			}
		}
		input[low] = input[q];
		input[q] = pivot;
		return q;
	}


	/**
	 * 
	 * @param input
	 * @param low
	 * @param high
	 * @return
	 */
	private int partitionLeft(int[] input, int low, int high) {
		int pivot = input[low];
		int p = low;
		int q = high;
		while (q > p) {
			while (p <= high && input[p] <= pivot) {
				p++;
			}
			while (q >= low && input[q] > pivot) {
				q--;
			}
			if (q > p) {
				swap(p, q, input);
			}
		}
		input[low] = input[q];
		input[q] = pivot;
		return q;
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
