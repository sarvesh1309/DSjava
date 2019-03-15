package com.practice.sorting;

public class BubbleSort {
	
	public void sort(int a[]) {
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < (a.length - i-1); j++) {
				if (a[j] > a[j +1]) {
					// swap elem
					int tmp = a[j];
					a[j] = a[j + 1];
					a[j + 1] = tmp;
				}
			}
		}
	}
	
	/**
	 * if already sorted then do not sort anymore
	 * @param a
	 */
	public void improvedSort(int a[]) {
		boolean sortedFlag = false;
		for (int i = 0; (i < a.length) && !sortedFlag; i++) {
			sortedFlag = true;
			for (int j = 0; j < (a.length - i - 1); j++) {
				if (a[j] > a[j + 1]) {
					// swap elem
					int tmp = a[j];
					a[j] = a[j + 1];
					a[j + 1] = tmp;
					sortedFlag = false;
				}
			}
		}
	}

}
