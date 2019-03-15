package com.practice.sorting;

public class SortingMainClass {
	
	
	public static void main(String s[]){
		BubbleSort bs  = new BubbleSort();
		int[] arrayToBeSorted = {5,1,3,2,6,4};
		bs.sort(arrayToBeSorted);
		for(int print:arrayToBeSorted){
		System.out.println(print);
		}
		
		bs.improvedSort(arrayToBeSorted);
		System.out.println("improved version of bubble sort");
		for(int print:arrayToBeSorted){
			System.out.println(print);
			}
	}

}
