package com.practice.dynamicprogramming;

import java.util.*;
import java.lang.*;
import java.io.*;

class MinJump {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.valueOf(br.readLine());
		while (t-- > 0) {
			int size = Integer.valueOf(br.readLine());
			String array[] = br.readLine().split(" ");
			int values[] = new int[size];
			for (int i = 0; i < size; i++) {
				values[i] = Integer.parseInt(array[i]);
			}
			// System.out.println(countRec(values,size,0));
			int[] mem = new int[size + 1];
			for (int i = 0; i < size + 1; i++) {
				mem[i] = -1;
			}
			System.out.println(countRecTopDown(values, size, 0, mem));

		}
	}

	public static int countRecTopDown(int[] values, int size, int index, int[] mem) {
		if (index >= size - 1) {
			return 0;
		}
		if (mem[index] != -1) {
			return mem[index];
		}
		int min = Integer.MAX_VALUE;
		for (int i = 1; i <= values[index]; i++) {
			min = Math.min(min, countRecTopDown(values, size, index + i, mem) + 1);
		}
		mem[index] = min;
		return min;
	}

	public static int countRec(int[] values, int size, int index) {
		if (index >= size - 1) {
			return 0;
		}
		int min = Integer.MAX_VALUE;
		for (int i = 1; i <= values[index]; i++) {
			min = Math.min(min, countRec(values, size, index + i) + 1);
		}
		return min;
	}
}