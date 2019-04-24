package com.practice.leetcode;

public class MedianOfTwoArray {
	
	private static void mergeSorted(int[] array1,int[] array2,int left,int right){
	     int count =0;
	      int mergeSorted[] = new int[array1.length+1];
	      int length = array1.length;
	      while((left<array1.length && right<array2.length) || count== length){
	      	if(array1[left]<array2[right]){	
	      		mergeSorted[count] = array1[left];
	      		left++;;
	      	}else{
	      		mergeSorted[count] = array2[right];
	      		right++;
	      	}
	      	count++;
	      }
	      if(left==array1.length){
	      	mergeSorted[count]=array2[0];
	      }else if(right==array2.length){
	      	mergeSorted[count]=array1[0];
	      }
	    // n move has been done . now either the left would be at n index , right would be at n index or both would be some where in middle 
	  // median would be the evg of n and n-1 index 
			double med = (mergeSorted[length]+mergeSorted[length-1])/2;
			System.out.print("med is :"+med);

		}

}
