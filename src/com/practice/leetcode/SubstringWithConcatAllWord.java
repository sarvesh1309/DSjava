package com.practice.leetcode;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class SubstringWithConcatAllWord {

	public List<Integer> findSubstring(String s, String[] words) {
		List<Integer> list = new LinkedList<Integer>();
		if (words.length == 0)
			return list;
		Set<Integer> visited = new HashSet<>();
		findSubstringHelper(s, words, list, 0, "", visited);
		return list;
	}

	private void findSubstringHelper(String s, String[] words, List<Integer> list, int index, String temp,
			Set<Integer> visited) {
		if (index == words.length) {
			System.out.println(temp);
			int ind = s.indexOf(temp);
			if (ind != -1 && !list.contains(ind)) {
				list.add(ind);
			}
			return;
		}
		for (int i = 0; i < words.length; i++) {
			if (!visited.contains(i) && s.indexOf(temp + words[i])!= -1) {
				visited.add(i);
				findSubstringHelper(s, words, list, index + 1, temp + words[i], visited);
				visited.remove(i);
			}
		}

	}

}
