package com.practice.sorting;

import java.util.ArrayList;

public class RadixSort {

	public int[] sort(int[] input) {
		Bucket bucket[] = new Bucket[10];
		int maxelem = -1;
		for (int val : input) {
			if (val > maxelem) {
				maxelem = val;
			}
		}
		int digits = findNumOfDigit(maxelem);
		for (int j = 0, i = 1; j < digits; j++) {
			radixSortHelper(input, i, bucket);
			i = i * 10;

		}

		return input;

	}

	private int findNumOfDigit(int maxelem) {
		int count = 1;
		int j = 10;
		while (maxelem / j != 0) {
			count++;
			j = j * 10;
		}
		return count;
	}

	/**
	 * Helper method to distribute the item in bucket and the finally add it in
	 * input array by picking from bucket in ordered way
	 * 
	 * @param input
	 * @param i
	 * @param buckets
	 */
	private void radixSortHelper(int[] input, int i, Bucket[] buckets) {
		for (int k = 0; k < buckets.length; k++) {
			buckets[k] = new Bucket();
		}

		for (int val : input) {
			// get the bucket num by mod and divide operation
			int k = val % (i*10);
			k = k / i;
			buckets[k].getList().add(val);
		}
		int j = 0;
		for (Bucket b : buckets) {
			for (int val : b.getList()) {
				input[j++] = val;
				System.out.println("input" + j + " :" + val);
			}
		}
	}

	/**
	 * 
	 * @author sarveshkumar
	 *
	 */
	class Bucket {
		ArrayList<Integer> list;

		public Bucket() {
			list = new ArrayList<>();
		}

		public ArrayList<Integer> getList() {
			return list;
		}
	}

}
