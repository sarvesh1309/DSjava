package com.practice.dynamicprogramming;

/**
 * only one quantity of each item is available
 * 
 * @author sarveshkumar
 *
 */
public class Knapsack01 {

	public static void printMaxValuesbottomUp(int wt[], int[] val, int size, int weight) {
		int[][] table = new int[size + 1][weight + 1];
		for (int i = 1; i <= size; i++) {
			for (int j = 1; j <= weight; j++) {
				if (wt[i - 1] <= j) {
					table[i][j] = Math.max(table[i - 1][j], val[i - 1] + table[i - 1][j - wt[i - 1]]);
				} else {
					table[i][j] = table[i - 1][j];
				}
			}
		}

		System.out.println(table[size][weight]);

	}

	public static int printMaxValuesTopDown(int wt[], int[] val, int weight, int selectedItem, int[][] mem) {
		if (weight <= 0 || selectedItem < 0) {
			return 0;
		}
		if (mem[weight][selectedItem] == -1) {
			if (wt[selectedItem] > weight) {
				mem[weight][selectedItem] = printMaxValuesTopDown(wt, val, weight, selectedItem - 1, mem);
			} else {
				mem[weight][selectedItem] = Math.max(printMaxValuesTopDown(wt, val, weight, selectedItem - 1, mem),
						printMaxValuesTopDown(wt, val, weight - wt[selectedItem], selectedItem - 1, mem)
								+ val[selectedItem]);
			}
		}

		return mem[weight][selectedItem];

	}

	public static int printMaxValuesRec(int wt[], int[] val, int weight, int selectedItem) {
		if (weight <= 0 || selectedItem < 0) {
			return 0;
		}
		int maxval = 0;

		if (wt[selectedItem] > weight) {
			maxval = printMaxValuesRec(wt, val, weight, selectedItem - 1);
		} else {
			maxval = Math.max(printMaxValuesRec(wt, val, weight, selectedItem - 1),
					printMaxValuesRec(wt, val, weight - wt[selectedItem], selectedItem - 1) + val[selectedItem]);
		}

		return maxval;

	}

}
