package com.practice.string;

import java.util.LinkedList;
import java.util.List;

public class TernarySearchTree {
	TSTNode root;

	public TernarySearchTree() {
		root = null;
	}

	/**
	 * 
	 * @param input
	 */
	public void insert(String input) {
		if (input == null || input.isEmpty()) {
			throw new RuntimeException("invalid string to insert");
		}
		root = insert(input, root, 0);
	}

	private TSTNode insert(String input, TSTNode curr, int i) {

		char ch = input.charAt(i);
		if (curr == null) {
			curr = new TSTNode(ch);
		}
		if (ch < curr.getData()) {
			curr.left = insert(input, curr.left, i);
		} else if (ch > curr.getData()) {
			curr.right = insert(input, curr.right, i);
		} else {
			if (i == (input.length() - 1)) {
				curr.endOfString = true;
			} else {
				curr.eq = insert(input, curr.eq, i + 1);
			}

		}

		return curr;

	}

	/**
	 * 
	 * @param input
	 * @return
	 */
	public boolean search(String input) {
		TSTNode curr = root;
		return search(input, curr, 0);
	}

	/**
	 * recrursive method to search
	 * 
	 * @param input
	 * @param curr
	 * @param i
	 * @return
	 */
	private boolean search(String input, TSTNode curr, int i) {
		if (curr == null) {
			return false;
		}
		if ((i == (input.length() - 1)) && !curr.endOfString) {
			return false;
		}
		char ch = input.charAt(i);
		if (curr.getData() == ch) {
			if ((i == input.length() - 1) && curr.endOfString == true) {
				return true;
			} else {
				return search(input, curr.eq, i + 1);
			}

		} else if (ch < curr.getData()) {
			return search(input, curr.left, i);
		} else {
			return search(input, curr.right, i);
		}
	}

	/**
	 * 
	 * @param input
	 * @return
	 */
	public void delete(String input) {
		TSTNode curr = root;
		if (input != null) {
			delete(input, curr, 0);
		}
	}

	private void delete(String input, TSTNode curr, int i) {
		if (curr == null) {
			return;
		}

		char ch = input.charAt(i);
		if (ch < curr.getData()) {
			delete(input, curr.left, i);
		} else if (ch > curr.getData()) {
			delete(input, curr.right, i);
		} else {
			if (curr.endOfString == true && i == (input.length() - 1)) {
				curr.endOfString = false;
			} else {
				delete(input, curr.eq, i);
			}
		}

	}

	/**
	 * 
	 */
	public void traverseAllString() {
		TSTNode curr = root;
		String str = "";
		List<String> list = new LinkedList<>();
		traverseAllString(curr, str, list);
		for (String val : list) {
			System.out.println(val);
		}
	}

	/**
	 * 
	 * @param curr
	 * @param word
	 * @param list
	 */
	private void traverseAllString(TSTNode curr, String word, List<String> list) {
		if (curr != null) {
			// traverse left string
			traverseAllString(curr.left, word, list);
			// append char of the current tstnode in word
			word = word + curr.getData();
			// if curr is the end of string then add this to list
			if (curr.endOfString) {
				list.add(word);
			}

			traverseAllString(curr.eq, word, list);
			// remove the last element added as it would not be part of right
			// tree string
			word = word.substring(0, word.length() - 1);
			traverseAllString(curr.right, word, list);
		}

	}

	public String findNextWord(String input) {
		TSTNode curr = root;
		String str = "";
		String output = "";
		findNextWord(curr, output, input, str, false);
		System.out.println(output);
		return output;
	}

	/**
	 * 
	 * @param curr
	 * @param nextword
	 * @param inputword
	 * @param tempword
	 * @param isPrevStringMatched
	 */
	private void findNextWord(TSTNode curr, String nextword, String inputword, String tempword,
			boolean isPrevStringMatched) {
		if (curr != null) {
			// traverse left string
			findNextWord(curr.left, nextword, inputword, tempword, isPrevStringMatched);
			// append char of the current tstnode in word
			tempword = tempword + curr.getData();
			// if curr is the end of string then add this to list

			if (curr.endOfString && isPrevStringMatched) {
				nextword = tempword;
				isPrevStringMatched = false;
			}
			if (curr.endOfString && (tempword.equalsIgnoreCase(inputword))) {
				isPrevStringMatched = true;
			}

			findNextWord(curr.eq, nextword, inputword, tempword, isPrevStringMatched);
			// remove the last element added as it would not be part of right
			// tree string
			tempword = tempword.substring(0, tempword.length() - 1);
			findNextWord(curr.right, nextword, inputword, tempword, isPrevStringMatched);
		}
	}

}

/**
 * TST node class
 * 
 * @author sarveshkumar
 *
 */
class TSTNode {
	TSTNode left;
	TSTNode right;
	TSTNode eq;
	boolean endOfString;
	private char data;

	public TSTNode() {
		endOfString = false;
	}

	public TSTNode(char ch) {
		this.data = ch;
		endOfString = false;
	}

	public char getData() {
		return data;
	}

	public void setData(char data) {
		this.data = data;
	}

}
