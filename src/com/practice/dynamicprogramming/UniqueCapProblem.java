package com.practice.dynamicprogramming;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class UniqueCapProblem {
	int count = 0;

	public void countUniqueWay(int n, Map<Integer, Set<Integer>> maps) {

		countRecursive(maps, 0, n, new HashSet<>());
		System.out.println(count);

	}

	public void countRecursive(Map<Integer, Set<Integer>> maps, int index, int n, Set<Integer> selectedCap) {
		if (n == index) {
			count++;
			selectedCap = new HashSet<>();
		} else {
			Set<Integer> set = maps.get(index);
			for (int x : set) {
				if (!selectedCap.contains(x)) {
					selectedCap.add(x);
					countRecursive(maps, index + 1, n, selectedCap);
					selectedCap.remove(x);
				}

			}
		}
	}

}
