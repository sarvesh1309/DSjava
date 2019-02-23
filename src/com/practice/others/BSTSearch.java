package com.practice.others;

public class BSTSearch {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums= {-1,0,3,5,9,12};
		int target = 13;
		System.out.println(search(nums, target));

	}
	
	
	 public static int search(int[] nums, int target) {
	        int startIndex =0;
	        int endIndex = nums.length-1;
	        while(startIndex<=endIndex){
	        	 System.out.println("startindex"+startIndex);
                 System.out.println("endIndex"+endIndex);
	            int mid = (startIndex+endIndex)/2;
	            System.out.println("mid"+mid);
	                if(target==nums[mid]){
	                    return mid;
	                }else if(target>nums[mid]){
	                    startIndex = mid+1;
	                   
	                }else {
	                    endIndex = mid-1;
	                }
	            
	        }
	        return -1;
	    }
	 public int mySqrt(int x) {
	        long start =0;
	        long end =x;
	        while (start<=end){
	            long mid =  start+(end-start)/2;
	            if(mid*mid==x){
	                return (int)mid;
	            } 
	            if(mid*mid>x){
	                end = mid-1;
	                  
	            } else {
	                 if((mid+1)*(mid+1)>x){
	                     return (int)mid;
	                 }
	                start = mid+1;
	            }
	        }
	        return (int)start-1;
	    }

}
