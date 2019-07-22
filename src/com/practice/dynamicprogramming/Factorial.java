package com.practice.dynamicprogramming;

public class Factorial {

	/**
	 * 
	 * @param n
	 */
	public void factorial(int n) {
		System.out.println(factorialTabulation(5));
	}

	/**
	 * bottom up approach as use the subproblem result to reach the
	 * 
	 * @param n
	 * @param fn
	 * @return
	 */
	private int factorialTabulation(int n) {
		int fn[] = new int[n + 1];
		fn[1] = 1;
		for (int i = 2; i <= n; i++) {
			fn[i] = i * fn[i - 1];
		}
		return fn[n];
	}

	/**
	 * top down approach as use the subproblem result to reach the
	 * 
	 * @param n
	 * @param fn
	 * @return
	 */
	private int factorialTopDown(int n, int fn[]) {
		fn[0] = 1;
		fn[1] = 1;
		if (fn[n] != -1) {
			return fn[n];
		}
		return n * factorialTopDown(n - 1, fn);
	}

}
