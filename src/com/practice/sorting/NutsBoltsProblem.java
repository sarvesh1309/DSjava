package com.practice.sorting;

public class NutsBoltsProblem {

	public void matchNutBolts(int[] nuts, int[] bolts) {

		// A recursive function which utilizes the quicksort to sort bolt array
		// by using nuts element as pivot and vice versa
		matchNutBoltHelper(nuts, bolts, 0, nuts.length - 1);

	}

	/**
	 * 
	 * @param nuts
	 * @param bolts
	 * @param low
	 * @param high
	 */
	private void matchNutBoltHelper(int[] nuts, int[] bolts, int low, int high) {
		if (high > low) {
			// take a last element from nut as pivot and do quick-sort on bolts
			// . it will place return a index where all smaller bolt would be on
			// left and bigger bolt in right
			int index = partition(bolts, low, high, nuts[high]);

			// use the same element from bolt and do the quick sort on nuts .it
			// will place all smaller nuts in left side and all bigger nuts in
			// right side

			partition(nuts, low, high, bolts[index]);
			matchNutBoltHelper(nuts, bolts, low, index - 1);
			matchNutBoltHelper(nuts, bolts, index + 1, high);

		}

	}

	/**
	 * 
	 * @param input
	 * @param low
	 * @param high
	 * @param pivot
	 * @return
	 */
	private int partition(int[] input, int low, int high, int pivot) {
		int left = low;

		for (int j = low; j < high; j++) {
			// if element is smaller than pivot then swap with the low element
			if (input[j] < pivot) {
				swap(input, left, j);
				left++;
				// if element is equal to pivot then swap with the element with
				// the last element
			} else if (input[j] == pivot) {
				swap(input, j, high);
				j--;
			}
		}
		// swap the high which is nothing but the pivot element with the low
		// element
		swap(input, left, high);
		return left;

	}

	/**
	 * swap element
	 * 
	 * @param input
	 * @param i
	 * @param high
	 */
	private void swap(int[] input, int i, int high) {
		int tmp = input[i];
		input[i] = input[high];
		input[high] = tmp;

	}

}
