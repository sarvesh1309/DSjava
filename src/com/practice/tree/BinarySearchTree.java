package com.practice.tree;

import com.practice.stack.Stack;

public class BinarySearchTree {
	Node root;

	public BinarySearchTree() {
		root = null;
	}
	
	public boolean searchElementTrav(int key) {
	   if(root==null) {
		   System.out.println("element not present");
		   return false;
	   }else {
		   Node focusNode = root;
			   while(focusNode!=null) {
				   if(key>focusNode.value) {
					   focusNode=focusNode.rightChild;
				   }else if (key==focusNode.value) {
					   return true;
				   }else {
					   focusNode=focusNode.leftChild;
				   }
			   }
			   return false;
		   }
	   
	}
	
	public boolean searchElement(int key) {
		return searchElementHelper(root, key);
	}

	private boolean searchElementHelper(Node rootNode, int value) {
		boolean isAvail = false;
		if (rootNode != null) {
			if (value == rootNode.value) {
				isAvail = true;
			} else if (value < rootNode.value) {
				isAvail = searchElementHelper(rootNode.leftChild, value);
			} else if (value > rootNode.value) {
				isAvail = searchElementHelper(rootNode.rightChild, value);
			} 
		}
		return isAvail;
	}

	public void addNode(int key) {
		Node newNode = new Node(key);
		if (root == null) {
			root = newNode;
		} else {
			Node focusNode = root;
			
			while (true) {
				
				if (key > focusNode.value) {
					//add in right tree
					
					if (focusNode.rightChild == null) {
						focusNode.rightChild = newNode;
						return;
					}
					focusNode = focusNode.rightChild;
				} else {
				

					if (focusNode.leftChild == null) {
						focusNode.leftChild = newNode;
						return;
					}
					focusNode = focusNode.leftChild;
				}
			}
		}
	}
	
	public void insert(int key) {
		root = insertKey(root, key);
	}

	private Node insertKey(Node rootNode, int key) {
		
		/* If the tree is empty, return a new node */
		if (rootNode == null) {
			Node node = new Node(key);
			return node;
		}
		/* Otherwise, recur down the tree */
		if (key < rootNode.value) {
			rootNode.leftChild = insertKey(rootNode.leftChild, key);
		} else {
			rootNode.rightChild = insertKey(rootNode.rightChild, key);
		}
		/* return the (unchanged) node pointer */
		return rootNode;
	}

	void InorderTrav() {
		InorderTravhelper(root);
	}

	private void InorderTravhelper(Node focusNode) {
		if (focusNode != null) {
			InorderTravhelper(focusNode.leftChild);
			System.out.println(focusNode.value);
			InorderTravhelper(focusNode.rightChild);
		}

	}
	
	
	
	void preOrder() {
		preOrderTravhelper(root);
	}
	
	void preOrderNonRecurs() {
		Stack stk = new Stack(10);
		Node focusNode = root;
		while(true) {
			while(focusNode!=null) {
				System.out.println(focusNode.value);
				stk.push(focusNode);
				focusNode = focusNode.leftChild;
			}
			if(stk.isEmptyStack()) {
				return;
			}
			focusNode = (Node)stk.pop();
			focusNode = focusNode.rightChild;
			
		}
	}

	private void preOrderTravhelper(Node focusNode) {
		if (focusNode != null) {
			System.out.println(focusNode.value);
			preOrderTravhelper(focusNode.leftChild);
			preOrderTravhelper(focusNode.rightChild);
		}

	}
	

	void postOrder() {
		postOrderTravhelper(root);
	}

	private void postOrderTravhelper(Node focusNode) {
		if (focusNode != null) {
			postOrderTravhelper(focusNode.leftChild);
			postOrderTravhelper(focusNode.rightChild);
			System.out.println(focusNode.value);
		}

	}
	
	
	
	

}
