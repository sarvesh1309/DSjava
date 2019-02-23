package com.practice.heap;

public class HeapOperations {
	
	public void heapsort(int a[]) {
		buildheap(a);
		int lenght = a.length;
		for(int i=lenght-1;i>0;i--) {
			//swap root element with last element then healpify by reducing size of heap by 1
			int tmp = a[i];
			a[i]=a[0];
			a[0]=tmp;
			heapify(a, i, 0);
		}
	}

	public void buildheap(int[] a) {
		int size = a.length;
		for(int i=(size-1)/2;i>=0;i--) {
			heapify(a,size,i);
		}
		
	}

	/**
	 * max heap and precolate down
	 * @param a
	 * @param size
	 * @param i
	 */
	public void heapify(int[] a, int size, int i) {
		int lpos = 2*i+1;
		if(lpos>=size)lpos=-1;
		int rpos = 2*i+2;
		if(rpos>=size)rpos=-1;
		int max =i;
		if(lpos!=-1 && a[i]<a[lpos])max=lpos;
		if(rpos!=-1 &&a[max]<a[rpos])max=rpos;
		if(max!=i) {
			int tmp = a[i];
			a[i]= a[max];
			a[max]=tmp;
			heapify(a, size, max);
		}
		
		
	}

}
