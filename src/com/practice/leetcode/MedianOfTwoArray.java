package com.practice.leetcode;

public class MedianOfTwoArray {

	/**
	 * use merge sort of array1 of m elem and array2 of n element. total time
	 * complexity would be time 0(m+n)
	 * 
	 * @param array1
	 * @param array2
	 * @param left
	 * @param right
	 */
	public static void mergeSorted(int[] array1, int[] array2) {
		int left = 0, right = 0;
		boolean isEven = false;
		int m = array1.length, n = array2.length;
		if ((m + n) % 2 == 0) {
			isEven = true;
		}
		int totalElemInMergeSorted = (m + n) / 2;
		int mergeSorted[] = new int[totalElemInMergeSorted + 1];
		int counter = 0;
		while (counter < (totalElemInMergeSorted + 1) && (left < array1.length && right < array2.length)) {
			if (array1[left] < array2[right]) {
				mergeSorted[counter] = array1[left];
				left++;
			} else {
				mergeSorted[counter] = array2[right];
				right++;
			}
			counter++;
		}
		if (counter < totalElemInMergeSorted + 1 && left == array1.length) {
			mergeSorted[counter] = array2[0];
		} else if (counter < totalElemInMergeSorted + 1 && right == array2.length) {
			mergeSorted[counter] = array1[0];
		}
		// if m+n is even then avg of m+n/2 and (m+n/2)-1 is median . If m+n is
		// odd then m+n/2 is median
		double median = 0;
		if (isEven) {
			median = Double.valueOf(mergeSorted[totalElemInMergeSorted] + mergeSorted[totalElemInMergeSorted - 1]) / 2;
		} else {
			median = mergeSorted[totalElemInMergeSorted];
		}
		System.out.print("medain is :" + median);

	}

	public double findMedian(int[] nums1, int[] nums2) {
		if (nums1.length > nums2.length) {
			return findMedian(nums2, nums1);
		}

		int lenx = nums1.length;
		int leny = nums2.length;
		int low = 0;
		int high = lenx;
		int midlength = (lenx + leny + 1) / 2;
		while (low <= high) {
			int partx = (high + low) / 2;
			int party = midlength - partx;
			int maxleftx = (partx == 0) ? Integer.MIN_VALUE : nums1[partx - 1];
			int minRightx = (partx == lenx) ? Integer.MAX_VALUE : nums1[partx];

			int maxlefty = (party == 0) ? Integer.MIN_VALUE : nums2[party - 1];
			int minRighty = (party == leny) ? Integer.MAX_VALUE : nums2[party];
			if (maxleftx <= minRighty && maxlefty <= minRightx) {
				// found the mid point
				if ((lenx + leny) % 2 == 0) {
					// total even number
					return ((double) Math.max(maxleftx, maxlefty) + Math.min(minRightx, minRighty)) / 2;
					//return ((double) Math.max(maxleftx, maxlefty) + Math.min(minRightx, minRighty))/2;
				} else {
					return (double) Math.max(maxleftx, maxlefty);
				}
			} else if (maxleftx > minRighty) {
				// move left
				high = partx - 1;
			} else {
				// move right
				low = partx + 1;
			}

		}
		throw new IllegalArgumentException();
	}

	public double findMedianSortedArrays(int input1[], int input2[]) {
		// if input1 length is greater than switch them so that input1 is
		// smaller than input2.
		if (input1.length > input2.length) {
			return findMedianSortedArrays(input2, input1);
		}
		int x = input1.length;
		int y = input2.length;

		int low = 0;
		int high = x;
		while (low <= high) {
			int partitionX = (low + high) / 2;
			int partitionY = (x + y + 1) / 2 - partitionX;

			// if partitionX is 0 it means nothing is there on left side. Use
			// -INF for maxLeftX
			// if partitionX is length of input then there is nothing on right
			// side. Use +INF for minRightX
			int maxLeftX = (partitionX == 0) ? Integer.MIN_VALUE : input1[partitionX - 1];
			int minRightX = (partitionX == x) ? Integer.MAX_VALUE : input1[partitionX];

			int maxLeftY = (partitionY == 0) ? Integer.MIN_VALUE : input2[partitionY - 1];
			int minRightY = (partitionY == y) ? Integer.MAX_VALUE : input2[partitionY];
			if (maxLeftX <= minRightY && maxLeftY <= minRightX) {
				// We have partitioned array at correct place
				// Now get max of left elements and min of right elements to get
				// the median in case of even length combined array size
				// or get max of left for odd length combined array size.
				if ((x + y) % 2 == 0) {
					return ((double) Math.max(maxLeftX, maxLeftY) + Math.min(minRightX, minRightY)) / 2;
				} else {
					return (double) Math.max(maxLeftX, maxLeftY);
				}
			} else if (maxLeftX > minRightY) { // we are too far on right side
												// for partitionX. Go on left
												// side.
				high = partitionX - 1;
			} else { // we are too far on left side for partitionX. Go on right
						// side.
				low = partitionX + 1;
			}
		}

		// Only we we can come here is if input arrays were not sorted. Throw in
		// that scenario.
		throw new IllegalArgumentException();
	}

}
