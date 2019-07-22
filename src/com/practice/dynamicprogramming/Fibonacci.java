/**
 * 
 */
package com.practice.dynamicprogramming;

/**
 * @author sarveshkumar
 *
 */
public class Fibonacci {

	/**
	 * bottom up approach Tabulation
	 * 
	 * @param n
	 * @return
	 */
	public int fib(int n) {
		int[] fib = new int[n+1];
		fib[0] = 0;
		fib[1] = 1;
		for (int i = 2; i <= n; i++) {
			fib[i] = fib[i - 1] + fib[i - 2];
		}
		return fib[n];

	}

	/**
	 * top down approach which use memoization
	 * 
	 * @param n
	 * @return
	 */
	public int fibMemoization(int n) {
		int fib[] = new int[n + 1];
		for (int i = 0; i <= n; i++) {
			fib[i] = -1;
		}
		return fibMemo(n, fib);

	}

	/**
	 * 
	 * @param n
	 * @param fib
	 * @return
	 */
	private int fibMemo(int n, int[] fib) {
		if (fib[n] == -1) {
			System.out.println("calling fib "+n);
			if (n <= 1) {
				fib[n] = n;
			} else {
				fib[n] = fibMemo(n - 1, fib) + fibMemo(n - 2, fib);
			}
		}
		return fib[n];
	}

}
