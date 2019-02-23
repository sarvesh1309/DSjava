package com.practice.tree;

import com.practice.queue.Queue;

public class TreeOperation {
	public static void main(String s[]) {
		BinarySearchTree binarytree = new BinarySearchTree();
		binarytree.insert(20);
		binarytree.addNode(10);
		binarytree.addNode(5);
		binarytree.addNode(14);
		binarytree.insert(30);
		binarytree.insert(35);
		binarytree.insert(25);
		System.out.println("inorder/n");
		binarytree.InorderTrav();
		System.out.println(binarytree.searchElement(30));
		System.out.println(binarytree.searchElementTrav(21));
		
	//	System.out.println("preorder/n");
		//binarytree.preOrder();
		//System.out.println("Non recursive preorder/n");
		//binarytree.preOrderNonRecurs();
		//System.out.println("postorder/n");
		//binarytree.postOrder();
		

		/*Node binaryNode = new Node(20);
		binaryNode.rightChild=new Node(30);
		binaryNode.rightChild.leftChild = new Node(60);
		binaryNode.leftChild=new Node(10);
		binaryNode.leftChild.rightChild=new Node(05);
		binaryNode.rightChild.rightChild = new Node(100);
		int max= findMax(binaryNode);
		System.out.println("max value is "+max);
		System.out.println("is 07 element present "+findElementRecur(binaryNode, 07));
		System.out.println("size of tree"+findSize(binaryNode));
		System.out.println("size of tree non recursive method"+findSizeNonRecur(binaryNode));*/
		
		
	}
	
	
	private static int findMax(Node root) {
		int max = 0;
		if(root!=null) {
			int root_value = root.value;
			int leftValue = findMax(root.leftChild);
			int rightValue = findMax(root.rightChild);
			if(leftValue>rightValue) {
				 max=leftValue;
			}else {
				max = rightValue;
			}
			if(root_value>max) {
				max=root_value;
			}
		}
		return max;
		
	}
	
	public static boolean findElement(Node root, int value) {
		if(root!=null) {
				Queue q = new Queue();
				q.enQueue(root);
				while(!q.isEmpty()) {
					Node node = (Node)q.deQueue();
					System.out.println("node value is "+node.value);
					System.out.println("searched value is "+value);
					
					if(node.value==value) {
						return true;
					}
					if(node.leftChild!=null) {
						q.enQueue(node.leftChild);
					}
					if(node.rightChild!=null) {
						q.enQueue(node.rightChild);
					}
				}
				q.deleteQueue();
			}
		return false;
	}
	
	public static boolean findElementRecur(Node root, int value) {
		if (root != null) {
			if (root.value == value) {
				return true;
			} else {
				boolean foundleft = findElementRecur(root.leftChild, value);
				if(foundleft==true) {
					return true;
				}
				return findElementRecur(root.rightChild, value);
				
			}
		}
		return false;
	}
	
	public static int findSize(Node root) {
		return findSizehelper(root,0);
	}
	
	private static int findSizehelper(Node root, int size) {
		if (root != null) {
		    size = size+1;
			 size  = findSizehelper(root.leftChild,size);
			 size = findSizehelper(root.rightChild,size);
		}
		return size;
	}
	
	public static int findSizeNonRecur(Node root) {
		int size=0;
		if(root!=null) {
			Queue q = new Queue();
			q.enQueue(root);
			while(!q.isEmpty()) {
				Node node = (Node)q.deQueue();
				size = size+1;
				if(node.leftChild!=null) {
					q.enQueue(node.leftChild);
				}
				if(node.rightChild!=null) {
					q.enQueue(node.rightChild);
				}
			}
			q.deleteQueue();
		}
		return size;
	}

}
