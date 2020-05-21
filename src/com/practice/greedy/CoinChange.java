package com.practice.greedy;

public class CoinChange {
	
	
	public static void printCoin(int sum){
	    int array[] = { 1, 2, 5, 10, 20, 50, 100, 200, 500, 2000};
	    int len = array.length;
	    for(int i = len-1 ;i>=0;i--){
	        while(sum >= array[i]){
	            System.out.print(array[i]+" ");
	            sum -= array[i];
	        }
	        if(sum == 0 ){
	            break;
	        }
	    }
	    System.out.println();
	}

}
