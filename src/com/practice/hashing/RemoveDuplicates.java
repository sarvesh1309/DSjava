package com.practice.hashing;

import java.util.HashSet;

public class RemoveDuplicates {

	/**
	 * bruteForce algorithm
	 * 
	 * @param input
	 */
	public void printAfterRemovingDuplicates(char[] input, int length) {
		for (int i = 0; i < length; i++) {
			char curr = input[i];
			for (int j = i + 1; j < length; j++) {
				if (input[j] == curr) {
					System.out.println("duplicate found");
					input[j] = input[--length];
				}
			}
		}

		for (int i = 0; i < length; i++) {
			System.out.println(input[i]);
		}

	}

	public void removeDuplicate(String str) {
		char input[] = str.toCharArray();
		HashSet<Character> set = new HashSet<>();
		int i, last;
		i = last = 0;
		for (; i < input.length; i++) {
			if (!set.contains(input[i])) {
				input[last++] = input[i];
				set.add(input[i]);
			}
		}
		input[last] = '\0';
		int j = 0;
		while (input[j] != '\0') {
			System.out.println(input[j]);
			j++;
		}

	}

}
