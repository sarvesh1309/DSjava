package com.practice.string;

import java.util.Map;

/**
 * dictionary using Trie datastructure
 * 
 * @author sarveshkumar
 *
 */
public class Dictionary {

	private DictionaryNode rootNode;

	/**
	 * adding word in dictionary
	 * 
	 * @param input
	 */
	public void addInDictionary(final String input) {
		DictionaryNode curr = rootNode;
		if (input == null || input.isEmpty()) {
			return;
		}
		for (int i = 0; i < input.length(); i++) {
			char ch = input.charAt(i);
			if (curr.getChild().containsKey(ch)) {
				curr = curr.getChild().get(ch);
			} else {
				DictionaryNode newnode = new DictionaryNode();
				curr.getChild().put(ch, newnode);
			}
		}
		curr.setEndOfString(true);
	}

	/**
	 * find next word from dictionary for given string
	 * 
	 * @param word
	 * @return
	 */
	public String findNextWordDictinary(String word) {
		return null;
	}

}

class DictionaryNode {
	private boolean endOfString;
	private Map<Character, DictionaryNode> child;

	public DictionaryNode() {
		endOfString = false;
	}

	public boolean isEndOfString() {
		return endOfString;
	}

	public void setEndOfString(boolean endOfString) {
		this.endOfString = endOfString;
	}

	public Map<Character, DictionaryNode> getChild() {
		return child;
	}

}
