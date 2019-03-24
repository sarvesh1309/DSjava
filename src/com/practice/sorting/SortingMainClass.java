package com.practice.sorting;

public class SortingMainClass {
	
	
	public static void main(String s[]){
		
		int[][] arrayToBeSorted = new int[][]{{2,4,7,8},{1,4,8,9},{0,1,3,7},{5,6,8,9,}};
		KwayMergeSorted sorting  = new KwayMergeSorted();
		int output[] = sorting.sort(arrayToBeSorted);
	
		System.out.println("final sorted array");
		for(int print:output){
			System.out.println(print);
			}
	}

}
