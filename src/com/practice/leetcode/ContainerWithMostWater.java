package com.practice.leetcode;

/**
 * leetcode 11
 * @author sarveshkumar
 *
 */
public class ContainerWithMostWater {
	/**
	 * O(n)
	 * iterate from left and right . if we find container bigger than previous one then move the pointer to container 
	 * to check if it is bigger than the previous one
	 * @param height
	 * @return
	 */
	public int maxArea(int[] height) {
		int right = height.length - 1;
		int left = 0;
		int max = 0;
		int xlength = 0;
		int ylength = 0;
		while (left < right) {
			xlength = right - left;
			if (height[left] < height[right]) {
				ylength = height[left];
				left++;
			} else {
				ylength = height[right];
				right--;
			}
			max = Math.max(max, (xlength * ylength));
		}

		return max;

	}

	/**
	 * O(n^2)
	 * iterate through all container and find the max area container
	 * @param height
	 * @return
	 */
	public int maxAreaIter(int[] height) {
		int max = 0;
		for (int i = 0; i < height.length; i++) {
			for (int j = i + 1; j < height.length; j++) {
				int area = Math.min(height[i], height[j]) * (j - i);
				if (area > max) {
					max = area;
				}
			}
		}
		return max;

	}

}
