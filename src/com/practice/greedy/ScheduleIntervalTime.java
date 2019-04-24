package com.practice.greedy;

import java.util.Arrays;

public class ScheduleIntervalTime {

	/**
	 * input paramater subset would contain the final output which has the subset
	 * @param array
	 * @param subset
	 * @return
	 */
	public static int FindMaxSubset(Task[] array, Task[] subset) {
		// sort based on the end time
		//sortBasedOnEndTime(array);
		Arrays.sort(array);
		int noOfElementsInSubset = 0;
		//add the first element in the subset
		subset[noOfElementsInSubset] = array[0];

		for (int i = 1; i < array.length; i++) {
			// iterate through sorted items and compare the interval starttime with the last choosed intverval's end time
			if (array[i].starttime > subset[noOfElementsInSubset].endtime) {
				subset[++noOfElementsInSubset] = array[i];
			}
		}
		return noOfElementsInSubset;

	}

	private static void sortBasedOnEndTime(Task[] array) {
		quicksort(array, 0, ((array.length) - 1));
	}

	// quick sort
	private static void quicksort(Task[] array, int start, int end) {
		if (end > start) {
			int pivot = pivot(array, start, end);
			quicksort(array, start, pivot - 1);
			quicksort(array, pivot + 1, end);
		}
	}

	private static int pivot(Task[] array, int start, int end) {
		int j = start-1;
		Task pivot = array[end];
		int i = start;
		for (; i <= (end - 1); i++) {

			if (array[i].endtime < pivot.endtime) {
				j++;
				swap(array, i, j);

			}
		}
		swap(array, end, (j + 1));
		return (j + 1);

	}

	//swappin the element in array
	private static void swap(Task[] array, int i, int j) {
		Task tmp = array[i];
		array[i] = array[j];
		array[j] = tmp;

	}

}

class Task implements Comparable<Task> {
	double starttime;
	double endtime;

	public Task(double start, double end) {
		this.starttime = start;
		this.endtime = end;
	}

	@Override
	public int compareTo(Task o) {
		if(o.endtime<this.endtime){
			return 1;
		}else if(o.endtime== this.endtime){
			return 0;
		}else{
			return -1;
		}
	}

}
