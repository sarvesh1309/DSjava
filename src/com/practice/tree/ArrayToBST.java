package com.practice.tree;

public class ArrayToBST {
	class Node {
        int data;
        Node left;
        Node right;
        public Node(int data){
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }
	
	public Node createBST(int[] array,int start, int end){
	    if(start <= end){
	        int med = start + (end - start)/2;
	        Node node = new Node(array[med]);
	        node.left = createBST(array,start,med-1);
	        node.right = createBST(array,med+1,end);
	        return node;
	    }
	    return null;
	}
	
	private void preOrder(Node root){
	    if(root != null){
	    System.out.print(root.data + " ");
	    preOrder(root.left);
	    preOrder(root.right);
	    }
	}

}
