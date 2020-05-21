	package com.practice.string;

/**
 * 
 * trie implementation using array which is applicable for only smaller case
 * character
 * 
 * @author sarveshkumar
 *
 */
public class TrieUsingArray {

	TrieNodeUsingArray root = null;

	public TrieUsingArray() {
		root = new TrieNodeUsingArray();
	}

	private int getIndex(char ch) {
		return ch - 'a';
	}

	/**
	 * 
	 * @param input
	 */
	public void insert(String input) {
		TrieNodeUsingArray curr = root;
		for (int i = 0; i < input.length(); i++) {
			char ch = input.charAt(i);
			// index of char which would be (ascii of ch - ascii of char 'a' )
			// e.g for character c index would be asciic of c (99) - asci of
			// 'a'(97) = 2
			int index = getIndex(ch);
			if (curr.child[index] == null) {
				TrieNodeUsingArray node = new TrieNodeUsingArray();
				curr.child[index] = node;
				curr = node;
			} else {
				curr = curr.child[index];
			}
		}
		curr.endOfString = true;
	}

	/**
	 * 
	 * @param input
	 * @return
	 */
	public boolean search(String input) {
		TrieNodeUsingArray curr = root;
		for (int i = 0; i < input.length(); i++) {
			char ch = input.charAt(i);
			// index of char which would be (ascii of ch - ascii of char 'a' )
			// e.g for character c index would be asciic of c (99) - asci of
			// 'a'(97) = 2
			int index = getIndex(ch);
			if (curr.child[index] == null) {
				return false;
			} else {
				curr = curr.child[index];
			}
		}
		return curr.endOfString;
	}

	/**
	 * delete a string from trie data structure
	 * 
	 * @param input
	 */
	public void delete(String input) {
		TrieNodeUsingArray curr = root;
		delete(curr, input, 0);
	}

	/**
	 * delete helper class which is a recursive method
	 * 
	 * @param curr
	 * @param input
	 * @param index
	 * @return
	 */
	private boolean delete(TrieNodeUsingArray curr, String input, int index) {
		if (input == null || input.length() == 0) {
			return false;
		}
		if (index == input.length()) {
			if (hasChildren(curr)) {
				curr.endOfString = false;
				return false;
			}
			return true;
		}
		char ch = input.charAt(index);
		// child index of the current char
		int j = getIndex(ch);
		TrieNodeUsingArray child = curr.child[j];
		index++;
		boolean isChildToBeDeleted = delete(child, input, index);
		if (isChildToBeDeleted) {
			curr.child[j] = null;
			return hasChildren(curr);
		}
		return false;

	}

	/**
	 * 
	 * @param curr
	 * @return
	 */
	private boolean hasChildren(TrieNodeUsingArray curr) {
		boolean hasChild = false;
		for (int i = 0; i < curr.child.length; i++) {
			if (curr.child[i] != null) {
				hasChild = true;
				break;
			}
		}
		return hasChild;

	}
}

class TrieNodeUsingArray {
	final int alphabet = 26;
	boolean endOfString;
	TrieNodeUsingArray[] child = new TrieNodeUsingArray[alphabet];;

	public TrieNodeUsingArray() {
		endOfString = false;
	}

}
