package com.practice.tree;

public class BSTMain {

	public static void main(String[] args) {
		BST bst = new BST();
		bst.insert(30);
		bst.insert(10);
		bst.insert(50);
		bst.insert(15);
		bst.insert(25);
		bst.insert(21);
		bst.insert(24);
		bst.insertNonRecur(35);
		bst.inorderTraver();
		/*bst.delete(21);
		System.out.println("afetr delete");
		bst.inorderNonRecurTrav();*/
		System.out.println("succesor of 10 : "+bst.InrderSuccessor(10).value);
		
		
		bst.printBetween(20,30);
	}

}
