package com.practice.hashing;

import java.util.HashSet;
import java.util.Set;

public class HappyNumber {
	
	public boolean isHappy(int n) {
		Set<Integer> set = new HashSet<Integer>();
		while (!set.contains(n)) {
			set.add(n);
			n = sumOfSquareOfDigit(n);
			if (n == 1) {
				return true;
			}
			
		}
		return false;
	}
	    
	
	private int sumOfSquareOfDigit(int n) {
		int sum = 0;
		while ((n / 10) != 0) {
			sum += Math.pow(n % 10,2);
			n = n / 10;
		}
		sum += Math.pow(n,2);
		return sum;
	}

}
