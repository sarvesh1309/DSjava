package com.practice.heap;

public class HeapMainClass {

	public static void main(String[] args) {

	/*	Heap hp = new Heap(5);
		hp.insert(3);
		hp.insert(5);
		hp.insert(1);
		hp.insert(8);
		hp.insert(6);
		hp.insert(7);
		hp.insert(9);
		hp.print();
		
		System.out.println("removing frmo min heap");
		//hp.delete();
		//hp.print();
		
		HeapOperations hop = new HeapOperations();
		int a[]  = new int[]{4,15,0,9,6,1,3,8,5,7};
		hop.heapsort(a);
		System.out.println("after sorting");
		for(int i=0;i<a.length;i++) {
			System.out.println(a[i]);
		}*/
		
		HeapQuestions hq = new HeapQuestions();
		System.out.println(hq.findKthMaxElement(new int[] {3, 5, 1,9,34,12,8,4,7,6,89},3));
		
		System.out.println(hq.findKthMaxElementHeapSort(new int[] {3, 5, 1,9,34,12,8,4,7,6,89},3));
		
		
	}

}
