package com.practice.sorting;

import java.util.ArrayList;

public class BucketSort {

	public int[] sort(int[] input) {
		int bucketSize = input.length;
		Bucket bucket[] = new Bucket[bucketSize];
		int[] sorted = new int[input.length];
		// initialize bucket
		for (int i = 0; i < bucket.length; i++) {
			bucket[i] = new Bucket();
		}

		// place input elements in the appropriate bucket. Use hashFunction to
		// determine the bucket number

		for (int i : input) {
			int k = hash(i, bucketSize);
			bucket[k].getList().add(i);
		}

		// sort the element in each bucket and add them in final sorted array
		for (int i = 0, j = 0; i < input.length; i++) {
			insertionSort(bucket[i].getList());
			for (int val : bucket[i].getList()) {
				sorted[j++] = val;
			}
		}
		return sorted;

	}

	/**
	 * 
	 * @param list
	 */
	private void insertionSort(ArrayList<Integer> list) {
		if (list.size() <= 1) {
			return;
		}
		for (int i = 1; i < list.size(); i++) {
			int curr = list.get(i);
			int j = i;
			while (j > 0 && curr < list.get(j - 1)) {
				list.set(j, list.get(j - 1));
				j--;
			}
			if (j != i) {
				list.set(j, curr);
			}
		}

	}

	/**
	 * Hash function depends on the input elements .General use case find the
	 * maxELem and minElem in input element .
	 * 
	 * @param i
	 * @return
	 */
	private int hash(int i, int bucketSize) {
		System.out.println(i / bucketSize);
		return i / bucketSize;
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
