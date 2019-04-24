package com.practice.greedy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class JobSequencing {
	/**
	 * 
	 * @param array
	 */
	public void printJobWithMaxProfit(Job array[]) {
		// sort job array based on the profit
		Arrays.sort(array, Collections.reverseOrder());
		int length = array.length;
		List<Job> outputjob = new ArrayList<>();
		boolean slot[] = new boolean[length];
		int profit = 0;
		for (int i = 0; i < array.length; i++) {
			// find the slot in which this job would fit 
			for (int j = (Math.min(length, array[i].getDeadLine()) - 1); j >= 0; j--) {
				if (!slot[j]) {
					System.out.println("adding job"+array[i].getJobId()+" : "+i);
					outputjob.add(array[i]);
					profit += array[i].getProfit();
					slot[j] = true;
					break;
				}
			}
		}

		System.out.println("max profit" + profit);
		System.out.println("jobs are:");
		for (Job j : outputjob) {
			System.out.println(j.getJobId());
		}

	}

}
