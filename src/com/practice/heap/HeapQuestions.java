package com.practice.heap;

public class HeapQuestions {

	// build heap and delete first element k times
	public int findKthMaxElement(int array[], int k) {
		// sort and then arrays[k] with give kth max elem
		// heapsort - O(nlogn)
		int locArray[] = array;
		// build heap
		buldheap(locArray);
		int count = 0;
		int maxElem = -1;
		if (k > array.length) {
			return -1;
		}
		while (true) {
			// first elem is always max
			maxElem = array[0];
			count++;
			// check of count has reached k then return current max element otherwise delete
			// the first element and heapify again
			if ((count) == k) {
				return maxElem;
			} else {
				int heapcount = (locArray.length)-(count-1);
				deleteMax(locArray,heapcount);
			}
		}
	}

	// O(logn complexity)
	private void deleteMax(int[] array,int count) {
		// swap first elem with last elem
		int tmp = array[0];
		array[0] = array[count-1];
		array[count - 1] = tmp;
		// heapify with other elements
		heapify(array, 0, count-1);

	}

	// O(n) complexity
	private void buldheap(int[] array) {
		int lenght = array.length;
		for (int i = (lenght - 1) / 2; i >= 0; i--) {
			int tmp = array[0];
			array[0] = array[i];
			array[i] = tmp;
			// build max Heap
			heapify(array, i, lenght);
		}

	}

	// heapify percolate down for max heap O(logn) complexity
	private void heapify(int[] array, int i, int size) {
		int lh = ((i * 2) + 1) >= size ? -1 : ((i * 2) + 1);
		int rh = ((i * 2) + 2) >= size ? -1 : ((i * 2) + 2);
		int max = i;
		if (lh != -1 && array[lh] > array[max]) {
			max = lh;
		}
		if (rh != -1 && array[rh]>array[max]) {
			max = rh;
		}
		if (max != i) {
			int tmp = array[i];
			array[i] = array[max];
			array[max] = tmp;
			heapify(array, max, size);
		}
	}
	
	
	public int findKthMaxElementHeapSort(int array[], int k) {
		// sort and then arrays[k] with give kth max elem
		// heapsort - O(nlogn)
		// build heap
		buldheap(array);
		if (k > array.length) {
			return -1;
		}
		for(int i=array.length-1;i>=0;i--) {
			int tmp = array[0];
			array[0] = array[i];
			array[i] = tmp;
			heapify(array, 0, i);
		}
		
		int indexFromLast = (array.length-k);
		return array[indexFromLast];
	}
	
	public int findKthMaxElementBinaryTree(int array[], int k) {
		return k;
		//build binary tree from array 
		
		
		// in order traversal for 3 indexes
	}

}
