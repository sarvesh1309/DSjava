package com.practice.leetcode;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class Escape {
	public boolean isEscapePossible(int[][] blocked, int[] s, int[] t) {

		if (blocked.length == 0)
			return true;

		return helper(blocked, s, t) && helper(blocked, t, s);
	}

	public boolean helper(int[][] blocked, int[] s, int[] target) {

		Set<String> set = new HashSet<>();
		for (int[] block : blocked) {
			set.add(block[0] + "_" + block[1]);
		}
		Queue<int[]> queue = new LinkedList<>();
		queue.offer(new int[] { s[0], s[1] });
		int level = 50;

		while (!queue.isEmpty() && level-- >= 0) {
			int size = queue.size();
			System.out.println(size);
			for (int i = 0; i < size; i++) {
				int[] t = queue.poll();
				String v = t[0] + "_" + t[1];
				if (t[0] == target[0] && t[1] == target[1])
					return true;

				if (!set.contains(v)) {
					set.add(v);
					if (t[0] - 1 >= 0) {
						System.out.println(t[0] - 1+" "+ t[1]);
						queue.offer(new int[] { t[0] - 1, t[1] });
					}

					if (t[0] + 1 <= 1000000) {
						System.out.println(t[0] + 1+" "+ t[1]);
						queue.offer(new int[] { t[0] + 1, t[1] });
					}

					if (t[1] - 1 >= 0) {
						System.out.println(t[0] +" "+ (t[1]-1));
						queue.offer(new int[] { t[0], t[1] - 1 });
					}

					if (t[1] + 1 <= 1000000) {
						System.out.println(t[0]+" "+ (t[1]+1));
						queue.offer(new int[] { t[0], t[1] + 1 });
					}
				}

			}
		}

		return !queue.isEmpty();
	}

}
