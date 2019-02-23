package com.practice.tree;

import java.util.Stack;

import javax.xml.crypto.Data;

public class BST {

	Node root;

	public void insert(int value) {
		root = insertRecur(root, value);
	}

	private Node insertRecur(Node curr, int value) {
		if (curr == null) {
			curr = new Node(value);
			return curr;
		} else {
			if (value > curr.value) {
				curr.rightChild = insertRecur(curr.rightChild, value);
			} else {
				curr.leftChild = insertRecur(curr.leftChild, value);
			}
			return curr;
		}

	}

	public void insertNonRecur(int value) {
		insertNonRecur(root, value);
	}

	private void insertNonRecur(Node curr, int value) {
		if (root == null) {
			root = new Node(value);
		} else {
			while (true) {
				if (value > curr.value) {
					if (curr.rightChild == null) {
						curr.rightChild = new Node(value);
						break;
					}
					curr = curr.rightChild;
				} else {
					if (curr.leftChild == null) {
						curr.leftChild = new Node(value);
						break;
					}
					curr = curr.leftChild;
				}
			}
		}

	}

	public void inorderTraver() {
		inorderTravHelper(root);

	}

	private void inorderTravHelper(Node curr) {
		if (curr != null) {
			inorderTravHelper(curr.leftChild);
			System.out.println(curr.value);
			inorderTravHelper(curr.rightChild);
		}

	}

	public void inorderNonRecurTrav() {
		Node curr = root;
		if (curr == null) {
			System.out.println("empty tree");
		} else {
			Stack<Node> s = new Stack<Node>();
			while (true) {
				while (curr != null) {
					s.push(curr);
					curr = curr.leftChild;
				}
				if (s.isEmpty()) {
					return;
				}
				curr = s.pop();
				System.out.println(curr.value);
				curr = curr.rightChild;
			}
		}

	}

	public void delete(int value) {
		deleteHelper(root, value);
	}

	public Node FindMax(Node curr) {
		if (curr == null) {
			return null;
		} else {
			while (curr.rightChild != null) {
				curr = curr.rightChild;
			}
			return curr;
		}
	}

	public Node deleteHelper(Node curr, int value) {
		if (curr == null) {
			return null;
		} else if (value < curr.value) {
			curr.leftChild = deleteHelper(curr.leftChild, value);
		} else if (value > curr.value) {
			curr.rightChild = deleteHelper(curr.rightChild, value);
		} else {
			// node found to be deleted
			if (curr.leftChild != null && curr.rightChild != null) {
				Node tmp = FindMax(curr.leftChild);
				curr.value = tmp.value;
				curr.leftChild = deleteHelper(curr.leftChild, value);
			} else if (curr.leftChild == null && curr.rightChild == null) {
				curr = null;
			} else {
				if (curr.leftChild == null) {
					curr = curr.rightChild;
				} else {
					curr = curr.leftChild;
				}
			}
		}

		return curr;
	}
	
	public Node InrderSuccessor( int value) {
		return InrderSuccessor(root, value);
	}
	
	public Node InrderSuccessor(Node root, int value) {
		Node node = findNode(root, value);
		if (node.rightChild != null) {
			node = node.rightChild;
			while (node.leftChild != null) {
				node = node.leftChild;
			}
			return node;
		} else {/*
			Node curr = root;
			Stack<Node> s = new Stack<Node>();
			while (curr.value != value) {
				if (value > curr.value) {
					curr = curr.rightChild;
					s.push(curr);
				} else {
					curr = curr.leftChild;
					s.push(curr);
				}
			}
			while(!s.isEmpty()) {
				Node tmp = (Node) s.pop();
				if(tmp.value>value) {
					return tmp;
				}
			}
		*/
		Node succesor = null;
		Node curr = root;
		while (curr.value != value) {
			if (value > curr.value) {
				curr = curr.rightChild;
			} else {
				succesor = curr;
				curr = curr.leftChild;
			}
		}
		return succesor;
		}

	}
	
	private Node findNode(Node root, int value) {
		while (root.value != value) {
			if (value > root.value) {
				root = root.rightChild;
			} else {
				root = root.leftChild;
			}
		}
		return root;
	}

	public void printBetween(int i, int j) {
		Node curr = root;
		printRec(curr,i,j);

	}

	private void printRec(Node curr, int i, int j) {
		if (curr != null) {
			printRec(curr.leftChild, i, j);
			if (curr.value<j) {
				if(curr.value>i) {
					System.out.println(curr.value);
				}
				printRec(curr.rightChild, i, j);
			}
		}

	}

}
