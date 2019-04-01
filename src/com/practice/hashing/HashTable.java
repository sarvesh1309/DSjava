package com.practice.hashing;

public class HashTable {

	double threaholdLoadFactor = .5;
	int tableSize = 0;

	HashTableNode[] nodes;

	/**
	 * create a hash table of given size
	 * 
	 * @param size
	 */
	public void creaeHashTable(int size) {
		this.tableSize = size;
		nodes = new HashTableNode[tableSize];
		for (int i = 0; i < tableSize; i++) {
			nodes[i] = new HashTableNode();
		}

	}

	public void insertInTable(int key, String value) {
		int hashKey = hashValue(key);

		// first head of the node at given calculated value
		ListNode head = nodes[hashKey].getStartNode();
		ListNode node = new ListNode();
		node.key = key;
		node.value = value;
		node.next = null;
		// if head is null then new node would be created which would be head
		// node
		if (head == null) {
			nodes[hashKey].setStartNode(node);
		} else {
			// find the last element by iterating over node . the assign new
			// node as the last node .
			while (head.next != null) {
				head = head.next;
			}
			head.next = node;
		}
		// if load factor passes a certain predefined threshold then double the
		// heap table size and rehash all elements
		nodes[hashKey].blockCount = nodes[hashKey].blockCount + 1;
		if ((nodes[hashKey].blockCount / tableSize) > threaholdLoadFactor) {
			rehash();
		}
	}

	/**
	 * rehash each element and add it back to table which has more bucket
	 */
	private void rehash() {
		// add the elements in temporary hashtable
		HashTableNode temp[] = nodes;
		tableSize = tableSize * 2;
		nodes = new HashTableNode[tableSize];
		for (int i = 0; i < tableSize; i++) {
			nodes[i] = new HashTableNode();
		}
		// iterate over temp table and add it in new hashtable
		for (int i = 0; i < temp.length; i++) {
			ListNode nodetmp = temp[i].startNode;
			while (nodetmp != null) {
				insertInTable(nodetmp.key, nodetmp.value);
				nodetmp = nodetmp.next;
			}
		}

	}

	/**
	 * 
	 * @param key
	 * @return
	 */
	public String searchInTable(int key) {
		// get the hash key
		int hashKey = hashValue(key);
		// search the element in separate chain
		ListNode head = nodes[hashKey].getStartNode();
		while (head != null) {
			if (head.key == key) {
				return head.value;
			}
			head = head.next;
		}
		System.out.println("key not found");
		return null;
	}

	public int hashValue(int value) {
		return value % tableSize;
	}
}

class ListNode {
	ListNode next;
	int key;
	String value;

	public ListNode() {
		this.next = null;
	}

}

class HashTableNode {
	ListNode startNode;
	double blockCount;

	public ListNode getStartNode() {
		return startNode;
	}

	public void setStartNode(ListNode startNode) {
		this.startNode = startNode;
	}

	public double getBlockCount() {
		return blockCount;
	}

	public void setBlockCount(int blockCount) {
		this.blockCount = blockCount;
	}

}
