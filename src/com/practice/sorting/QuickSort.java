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
			int pivot = partitionRightImproved(input, low, high);
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
		int pivot = input[low + (high - low) / 2];
		int left = low;
		int right = high;
		while (right >= left) {
			while (input[left] < pivot) {
				left++;
			}
			while (input[right] > pivot) {
				right--;
			}
			if (right >= left) {
				swap(left, right, input);
				left++;
				right--;
			}
		}
		return left;

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
		int left = low;
		int right = high;
		while (right >= left) {
			left++;
			while (left <= high && input[left] < pivot) {
				left++;
			}
			while (right >= low && input[right] > pivot) {
				right--;
			}
			if (left < right) {
				swap(left, right, input);
			}
		}
		// swap right element with the pivot
		input[low] = input[right];
		input[right] = pivot;
		return right;
	}

	/**
	 * 
	 * @param input
	 * @param low
	 * @param high
	 * @return
	 */
	private int partitionRight(int[] input, int low, int high) {
		int pivot = input[high];
		int left = low;
		int right = high;
		while (right >= left) {
			right--;
			while (left <= high && input[left] < pivot) {
				left++;
			}
			while (right >= low && input[right] > pivot) {
				right--;
			}
			if (left < right) {
				swap(left, right, input);
			}
		}
		// swap left element with the pivot
		input[high] = input[left];
		input[left] = pivot;
		return left;
	}

	/**
	 * this function takes the righmost element as the pivot element and then
	 * then position it in the array so that the all the element left to pivot
	 * element would be smaller and all the element on right of pivot would be
	 * greater
	 * 
	 * @param input
	 * @param low
	 * @param high
	 * @return
	 */
	private int partitionRightImproved(int[] input, int low, int high) {
		int pivot = input[high];
		// index of last smaller element than pivot
		int i = low - 1;
		for (int j = low; j < high; j++) {
			// if current element is smaller than the pivot element the swap it
			// with the (lastsmaller+1) element
			if (input[j] <= pivot) {
				i++;
				swap(i, j, input);
			}
		}
		// swap the pivot element with next to last smaller element
		swap(i + 1, high, input);
		return i + 1;
	}

	/**
	 * 
	 * @param input
	 * @param low
	 * @param high
	 * @return
	 */
	private int partitionRandom(int[] input, int low, int high) {
		int pivotPos = low + (int) (Math.random() * (high - low));
		System.out.println("random choosen pos" + pivotPos);
		swap(low, pivotPos, input);
		// swap pivot with leftmost element and then call partition with
		// partition which choose left most element
		return partitionLeft(input, low, high);

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
