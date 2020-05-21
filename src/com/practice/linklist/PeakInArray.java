package com.practice.linklist;

import java.util.ArrayList;
import java.util.List;

public class PeakInArray {
	public static int countNumoPeaks(int[] a) {
		int count = 0;
		int prev = Integer.MIN_VALUE;
		int n = a.length;
		List<Integer> list = new ArrayList<>();
		for (int i = 0; i < n - 1; i++) {
			if (a[i] >= prev && a[i] >= a[i + 1]) {
				list.add(a[i]);
				System.out.println(a[i]);
				count++;
			}
			prev = a[i];
		}
		if (a[n - 1] >= a[n - 2]) {
			count++;
			list.add(a[n - 1]);
		}
		return count;

	}

	public static int findPeak(int[] a) {
		int count = 0;
		int start = 0;
		int end = a.length;
		while (end >= start) {
			int mid = start + (end - start) / 2;
			if ((mid == 0 || a[mid] >= a[mid - 1]) && (mid == a.length || a[mid] >= a[mid + 1])) {
				return a[mid];
			} else if (mid > 0 && a[mid] < a[mid - 1]) {
				end = mid-1;
			} else {
				start = mid+1;
			}
		}
		return count;
	}

}
