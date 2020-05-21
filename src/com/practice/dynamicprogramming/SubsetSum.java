package com.practice.dynamicprogramming;

public class SubsetSum {

	public static void main(String[] args) {
		int[] array = { 1, 3, 6 };
		int sum = 0;
		for (int i : array) {
			sum += i;
		}
		System.out.println(isPossibleSumSubset(array, sum / 2,0));
	}

	public static boolean isPossibleSumSubset(int[] array, int sum, int index) {
		if (sum == 0) {
			return true;
		}
		if (index >= array.length || sum < 0)
			return false;
		if (isPossibleSumSubset(array, sum - array[index], index + 1)) {
			return true;
		} else {
			return isPossibleSumSubset(array, sum, index + 1);
		}
	}

	public static boolean isSubsetSumExists(int[] array, int sum) {
		boolean visited[] = new boolean[array.length];
		for (int i = 0; i < array.length; i++) {
			visited[i] = true;
			if (issubsetExist(array, visited, sum - array[i], 1)) {
				return true;
			}
			visited[i] = false;
		}
		return false;
	}

	private static boolean issubsetExist(int[] array, boolean[] visited, int sum, int index) {
		if (sum == 0) {
			return true;
		}
		if (sum < 0)
			return false;
		if (index >= array.length)
			return false;
		boolean foundFlag = false;
		for (int i = 0; i < array.length; i++) {
			if (!visited[i]) {
				visited[i] = true;
				sum -= array[i];
				index++;
				foundFlag = issubsetExist(array, visited, sum, index);
				if (foundFlag)
					break;
			}
			visited[i] = false;
			sum += array[i];
		}
		return foundFlag;
	}

}
