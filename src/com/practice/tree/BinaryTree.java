package com.practice.tree;

import java.util.Stack;

import com.practice.queue.Queue;

public class BinaryTree {
	
	Node root=null;
	
	public void insert(int data) {
		if(root==null) {
			root = new Node(data);
			return;
		}
		Queue q= new Queue();
		q.enQueue(root);
		while(!q.isEmpty()) {
			Node tmp = (Node) q.deQueue();
			if(tmp.leftChild!=null) {
				q.enQueue(tmp.leftChild);
			}else {
				tmp.leftChild=new Node(data);
				break;
			}
			if(tmp.rightChild!=null) {
				q.enQueue(tmp.rightChild);
			}else {
				tmp.rightChild=new Node(data);
				break;
			}
		}
		q.deleteQueue();
		
	}
	public int findSizeRec() {
		Node curr= root;
		return findSizeRecHelper(curr);
	}
	
	private int findSizeRecHelper(Node curr) {
		if(curr==null) {
			return 0;
		}else {
			int ls = findSizeRecHelper(curr.leftChild);
			int rs= findSizeRecHelper(curr.rightChild);
			return ls+rs+1;
		}
	}
	
	public int findSizeNonRec() {
		int size= 0 ;
		Node curr= root;
		Queue q = new Queue();
		q.enQueue(curr);
		while(!q.isEmpty()) {
			curr= (Node) q.deQueue();
			size++;
			if(curr.leftChild!=null) {
				q.enQueue(curr.leftChild);
			}
			if(curr.rightChild!=null) {
				q.enQueue(curr.rightChild);
			}
					
		}
		q.deleteQueue();
		return size;
	}
	
	public int maxElemRec() {
		Node curr= root;
		return maxElemRecHelper(curr);
	}

	private int maxElemRecHelper(Node curr) {
		if (curr == null) {
			return 0;
		} else {
			int max = Integer.MIN_VALUE;
			int lmax = maxElemRecHelper(curr.leftChild);
			int rmax = maxElemRecHelper(curr.rightChild);
			if (lmax > rmax) {
				max = lmax;
			} else {
				max = rmax;
			}
			if (max < curr.value) {
				max = curr.value;
			}
			return max;
		}
	}
	public int maxElemNonRec() {
		int max = Integer.MIN_VALUE;
		Node curr= root;
		Queue q =new Queue();
		q.enQueue(curr);
		
		while(!q.isEmpty()) {
			curr= (Node) q.deQueue();
			if(curr.value>max) {
				max= curr.value;
			}
			if(curr.leftChild!=null) {
				q.enQueue(curr.leftChild);
			}
			if(curr.rightChild!=null) {
				q.enQueue(curr.rightChild);
			}
		}
		q.deleteQueue();
		return max;
	}
	public boolean searchElemRec(int elem) {
		Node curr = root;
		return searchElemRecHelper(curr,elem);
	}
	
	private boolean searchElemRecHelper(Node curr, int elem) {
		if (curr == null) {
			return false;
		} else if (curr.value == elem) {
			return true;
		} else {
			boolean isExist = searchElemRecHelper(curr.leftChild, elem);
			if (isExist) {
				return isExist;
			}
			isExist = searchElemRecHelper(curr.rightChild, elem);
			return isExist;
		}
	}
	public boolean searchElemNonRec(int elem) {
		Node curr= root;
		Queue q =new Queue();
		q.enQueue(curr);
		
		while(!q.isEmpty()) {
			curr= (Node) q.deQueue();
			if(curr.value==elem) {
				return true;
			}
			if(curr.leftChild!=null) {
				q.enQueue(curr.leftChild);
			}
			if(curr.rightChild!=null) {
				q.enQueue(curr.rightChild);
			}
		}
		q.deleteQueue();
		return false;
	}
	
	public void printInLevelOrder() {
		System.out.println("print levelorder");
		if(root==null) {
			System.out.println("empty queue");
			return;
		}
		Queue q = new Queue();
		q.enQueue(root);
		while(!q.isEmpty()) {
			Node tmp = (Node) q.deQueue();
			System.out.println(tmp.value+"\t");
			if(tmp.leftChild!=null) {
				q.enQueue(tmp.leftChild);
			}
			if(tmp.rightChild!=null) {
				q.enQueue(tmp.rightChild);
			}
		}
		q.deleteQueue();
	}
	
	
	public void printInLevelReverseOrder() {
		System.out.println("print revLevelorder");
		if(root==null) {
			System.out.println("tree is empty");
			return;
		}
		Queue q = new Queue();
		q.enQueue(root);
		Stack<Node> s = new Stack<Node>();
		while(!q.isEmpty()) {
			Node tmp = (Node) q.deQueue();
			s.push(tmp);
			if(tmp.leftChild!=null) {
				q.enQueue(tmp.leftChild);
			}
			if(tmp.rightChild!=null) {
				q.enQueue(tmp.rightChild);
			}
		}
		q.deleteQueue();
		while(!s.isEmpty()) {
			Node tmp = s.pop();
			System.out.println(tmp.value);
		}
		s.empty();
	}
	
	
	public void printPreOrderNonRec() {
		System.out.println("print preorder");
		if(root==null) {
			System.out.println("tree is empty");
			return;
		}
		Node curr = root;
		Stack<Node> s = new Stack<Node>();
		while(true) {
			while(curr!=null) {
				s.push(curr);
				System.out.println(curr.value);
				curr = curr.leftChild;
			}
			if(s.isEmpty()) {
				break;
			}
			curr = s.pop();
			curr = curr.rightChild;
		}
		s.clear();
		
	}
	public void printInOrderNonRec() {
		System.out.println("print Inorder");
		if(root==null) {
			System.out.println("tree is empty");
			return;
		}
		Node curr = root;
		Stack<Node> s = new Stack<Node>();
		while(true) {
			while(curr!=null) {
				s.push(curr);
				curr = curr.leftChild;
			}
			if(s.isEmpty()) {
				break;
			}
			curr = s.pop();
			System.out.println(curr.value);
			curr = curr.rightChild;
		}
		s.clear();
		
	}
	public void printPostOrderNonRec() {
		System.out.println("print Postorder");
		if(root==null) {
			System.out.println("tree is empty");
			return;
		}
		Node curr = root;
		Stack<Node> s = new Stack<Node>();
		Node prev = null;
		do {
			while(curr!=null) {
				s.push(curr);
				curr = curr.leftChild;
			}
			curr = s.peek();
			if(curr.rightChild==null || curr.rightChild==prev) {
				curr = s.pop();
				System.out.println(curr.value);
				prev = curr;
				curr = null;
			}else {
				curr = curr.rightChild;
			}
			
			
		}while(!s.isEmpty());
	}

	public void deleteTree() {
		
	}
	public void findHeightNonRec() {
		
		
	}
	public void deleteNode(int data) {
		
	}
	
	public void printAncestor(int value) {
	Node curr = root;
	Stack<Integer> s = new Stack<Integer>();
	    printAncestorHelper(curr,value,s);
	    while(!s.isEmpty()) {
	    	System.out.println(s.pop());
	    }
	}
	private int printAncestorHelper(Node curr, int value,Stack<Integer> s) {
		if(curr==null) {
			return 0;
		}
		if(curr.value==value) {
			return 1;
		}
		int lc = printAncestorHelper(curr.leftChild, value, s);
		int rc = printAncestorHelper(curr.rightChild, value,s);
		if(lc==0 && rc==0) {
			return 0;
		}
		if(lc==1^rc==1) {
			s.push(curr.value);
			return 1;
		}
		return 0;
		
	}
	
	public Node LeastCommonAncestor(int value1, int value2) {
		Node curr = root;
		return LeastCommonAncestor(curr, value1, value2);
	}
	
	private Node LeastCommonAncestor(Node curr, int value1,int value2){
		if(curr==null) {
			return null;
		}
		if(curr.value==value1 || curr.value==value2) {
			return curr;
		}
		Node lc = LeastCommonAncestor(curr.leftChild,value1, value1);
		Node rc = LeastCommonAncestor(curr.rightChild,value1, value2);
		if(lc==null && rc==null) {
			return null;
		}
		if(lc!=null && rc!=null) {
			return curr;
		}
		return lc!=null?lc:rc;
			
		
	}
	
	public int DiameterOfTree() {
		Node curr = root;
		return DiameterTreeHelper(curr);
	}
	private int DiameterTreeHelper(Node curr) {
		if(curr==null) {
			return 0;
		}
		int lh = heightHelper(curr.leftChild);
		int rh = heightHelper(curr.rightChild);
		int ld = DiameterTreeHelper(curr.leftChild);
		int rd= DiameterTreeHelper(curr.rightChild);
		return(Math.max(lh+rh+1,Math.max(ld,rd)));
	}
	
	public int heightOfTree() {
		Node curr= root;
		return heightHelper(curr);
	}
	
	private int heightHelper(Node curr) {
		if(curr==null) {
		return 0;
		}
		return (Math.max(heightHelper(curr.leftChild),heightHelper(curr.rightChild))+1);
	}
	
	public int isMirror(Node root1, Node root2) {
		if (root1 == null && root2 == null) {
			return 1;
		}
		if (root1 == null ^ root2 == null) {
			return 0;
		}
		if (root1.value != root2.value) {
			return 0;
		} else {
			if (isMirror(root1.leftChild, root2.rightChild) == 1 && isMirror(root1.rightChild, root2.leftChild) == 1) {
				return 1;
			}else {
				return 0;
			}
		}

	}
	
}
