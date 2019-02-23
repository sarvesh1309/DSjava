package com.practice.heap;

import java.util.Arrays;

public class Heap {
	private int[] values;
	int count;
	private int capacity;

	public Heap(int capacity) {
		this.capacity = capacity;
		values = new int[capacity];
		count = 0;
	}

	public void insert(int data) {
		if (count == capacity) {
			capacity = capacity * 2;
			values = Arrays.copyOf(values, capacity);
		}
		values[count] = data;
		count++;
		percolateUp(count - 1);
	}

	public void print() {
		for (int i = 0; i < count; i++) {
			System.out.println(values[i]);
		}
	}

	/**
	 * you can always delete from front in heap . thus always first element would
	 * get deleted . Solution is to replace first element with last element and
	 * reduce heap size . after that use percolate down to heapify
	 * 
	 * @return
	 */
	public int delete() {
		int deleted = values[0];
		values[0] = values[count - 1];
		count--;
		percolateDown(0);
		return deleted;

	}

	/**
	 * heapify from bottom to up
	 * 
	 * @param i
	 */
	public void percolateUp(int i) {
		while (i > 0 && values[i] < values[(i - 1) / 2]) {
			// swap values if parent values is greater than child
			int tmp = values[i];
			values[i] = values[(i - 1) / 2];
			values[(i - 1) / 2] = tmp;
			i = (i - 1) / 2;
		}

	}

	/**
	 * heapify from top to bottom
	 * 
	 * @param i
	 */
	public void percolateDown(int i) {
		int left = leftChild(i);
		int right = rightChild(i);
		int minPos = i;
		if (left != -1 && values[left] < values[i]) {
			minPos = left;
		} else if (right != -1 && values[right] < values[minPos]) {
			minPos = right;
		}
		if (minPos != i) {
			// swap values with child with lower values
			int tmp = values[i];
			values[i] = values[minPos];
			values[minPos] = tmp;
			percolateDown(minPos);
		}

	}

	/**
	 * 
	 * @param i
	 * @return
	 */
	private int leftChild(int i) {
		int left = (i * 2) + 1;
		if (left >= count) {
			return -1;
		}
		return left;
	}

	/**
	 * 
	 * @param i
	 * @return
	 */
	private int rightChild(int i) {
		int right = (i * 2) + 1;
		if (right >= count) {
			return -1;
		}
		return right;
	}
	


}
