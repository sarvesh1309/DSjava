package com.practice.greedy;

public class Job implements Comparable<Job> {
	/**
	 * job class
	 * 
	 * @author sarveshkumar
	 *
	 */
	private int deadline;
	private int profit;
	private String jobId;

	public Job(String id, int d, int p) {
		this.deadline = d;
		this.profit = p;
		this.jobId = id;
	}

	public int getDeadLine() {
		return deadline;
	}

	public int getProfit() {
		return profit;
	}

	public String getJobId() {
		return jobId;
	}

	public int compareTo(Job j) {
		if (this.profit > j.profit) {
			return 1;
		} else if (this.profit < j.profit) {
			return -1;
		} else {
			return 0;
		}

	}
}
