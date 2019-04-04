package com.practice.string;

import java.util.HashMap;

public class TrieNode {
	boolean end_of_string;
	HashMap<Character, TrieNode> childNode;
	
	public TrieNode(){
		childNode = new HashMap<>();
		end_of_string = false;
	}

}
