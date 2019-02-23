package com.practice.backtracking;

public class PrintBinary {
	
	
	public static void main(String s[]) {
		PrintBinary pb = new PrintBinary();
		pb.printBinary(3);
	}
	
	int[] binaryArray;
	void printBinary(int n) {
		binaryArray = new int[n];
		printBinarywithout(n);
		
		System.out.println("now with order");
		printBinaryInOrder(n,"");
	}
	
//this solution i got it from Data structure book
	void printBinarywithout(int n) {
		if (n == 0) {
			printArray(binaryArray);
		} else {
			binaryArray[n - 1] = 0;
			printBinarywithout(n - 1);
			binaryArray[n - 1] = 1;
			printBinarywithout(n - 1);
		}
	}

	void printArray(int[] array) {
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i]);
		}
		System.out.println("");
	}

	 
	// this solution i got it from by following "martystepp" youtube channel

	void printBinaryInOrder(int n, String output) {
		if (n==0) {
			System.out.println(output);
		} else {
			printBinaryInOrder(n-1,output+"0");
			printBinaryInOrder(n-1,output+"1");
		}
	}

}
