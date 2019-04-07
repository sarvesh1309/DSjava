package com.practice.string;

import java.util.HashMap;

public class Trie {
	TrieNode rootNode = null;

	public Trie() {
		rootNode = new TrieNode();
	}

	/**
	 * 
	 * @param input
	 */
	public void insert(String input) {
		// if input string is empty then mark the root node as end of string
		if (input.length() == 0) {
			rootNode.end_of_string = true;
		}
		TrieNode currentNode = rootNode;
		for (int i = 0; i < input.length(); i++) {
			char ch = input.charAt(i);
			// if char is found at the current level then found trie node will
			// become current node

			if (currentNode.childNode.containsKey(ch)) {
				currentNode = currentNode.childNode.get(ch);
			} else {
				// if char is not found the create a new trie node and make this
				// as one of child of current node . Now move the current node
				// pointer to current node .
				TrieNode newNode = new TrieNode();
				currentNode.childNode.put(ch, newNode);
				currentNode = newNode;
			}
		}
		currentNode.end_of_string = true;
	}

	/**
	 * 
	 * @param input
	 * @return
	 */
	public boolean searchInTrie(String input) {
		TrieNode currentNode = rootNode;
		for (int i = 0; i < input.length(); i++) {
			char ch = input.charAt(i);
			if (currentNode.childNode.containsKey(ch)) {
				currentNode = currentNode.childNode.get(ch);
			} else {
				return false;
			}
		}
		return currentNode.end_of_string ? true : false;

	}

	/**
	 * 
	 * @param input
	 * @return
	 */
	public void deleteFromTrie(String input) {
		TrieNode currentNode = rootNode;
		delete(currentNode, input, 0);

	}

	/**
	 * 
	 * @param currNode
	 * @param word
	 * @param index
	 * @return
	 */
	private boolean delete(TrieNode currNode, String word, int index) {
		// if index is at the end if word
		if (index == word.length()) {
			// if it is not end of string it means word does not exist thus no
			// action by returning false
			if (!currNode.end_of_string) {
				return false;
			}
			// word found and unmark the end of word
			currNode.end_of_string = false;
			// if no child node then it means this trie node can be deleted
			return currNode.childNode.size() == 0;
		}
		char ch = word.charAt(index);
		TrieNode node = currNode.childNode.get(ch);
		if (node == null) {
			return false;
		}
		// if child node can be deleted and it is not marking the end of other
		// words then delete child node
		boolean shouldDeleteCurrentNode = delete(node, word, index + 1) && !node.end_of_string;

		if (shouldDeleteCurrentNode) {
			currNode.childNode.remove(ch);
			return currNode.childNode.isEmpty();
		}
		return false;
	}

}

class TrieNode {
	boolean end_of_string;
	HashMap<Character, TrieNode> childNode;

	public TrieNode() {
		childNode = new HashMap<>();
		end_of_string = false;
	}

}
