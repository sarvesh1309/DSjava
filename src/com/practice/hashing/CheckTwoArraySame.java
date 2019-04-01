package com.practice.hashing;

import java.util.HashMap;

import com.practice.sorting.QuickSort;

public class CheckTwoArraySame {

	/**
	 * O(n)
	 * 
	 * @param input1
	 * @param input2
	 * @return
	 */
	public boolean isTwoArraySame(int[] input1, int[] input2) {
		HashMap<Integer, Integer> map1 = new HashMap<>();
		// add the element from first array into hashmap
		for (int i = 0; i < input1.length; i++) {
			if (map1.containsKey(input1[i])) {
				int val = map1.get(input1[i]);
				map1.put(input1[i], ++val);
			} else {
				map1.put(input1[i], 1);
			}
		}
		// iterate over second array .if any element is not present in hashmap
		// then both array are not same set . if element found in
		// then reduce the count
		for (int i = 0; i < input2.length; i++) {
			if (!map1.containsKey(input2[i])) {
				return false;
			} else {
				int val = map1.get(input2[i]);
				map1.put(input2[i], --val);
			}
		}
		// iterate over map . if all count is not 0 then it means quantity of
		// that element is not same in both array
		for (int s : map1.keySet()) {
			if (map1.get(s) != 0) {
				return false;
			}
		}
		return true;
	}

	/**
	 * O(nlogn)
	 * 
	 * @param input1
	 * @param input2
	 * @return
	 */
	public boolean isTwoArraySameSortingWay(int[] input1, int[] input2) {
		QuickSort sort = new QuickSort();
		input1 = sort.quickSort(input1);
		input2 = sort.quickSort(input2);
		for (int i = 0; i < input1.length; i++) {
			if (input1[i] != input2[i]) {
				return false;
			}
		}
		return true;

	}

}
