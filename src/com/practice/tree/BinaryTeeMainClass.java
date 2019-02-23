package com.practice.tree;

public class BinaryTeeMainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BinaryTree btree= new BinaryTree();
		btree.insert(10);
		btree.insert(20);
		btree.insert(30);
		btree.insert(40);
		btree.insert(50);
		btree.insert(60);
		btree.insert(70);
	//	btree.printInLevelOrder();
	  // System.out.println("height"+btree.heightOfTree());
	   //System.out.println("Diameter "+btree.DiameterOfTree());
	//	btree.printPreOrderNonRec();
		//btree.printInOrderNonRec();
		//btree.printPostOrderNonRec();
		//btree.printInLevelReverseOrder();
		//System.out.println("rec size"+btree.findSizeRec());
		//System.out.println("Non rec size"+ btree.findSizeNonRec());
		//System.out.println("max elem rec"+btree.maxElemRec());
		//System.out.println("max elem Nonrec"+btree.maxElemNonRec());
		//System.out.println("search rec "+btree.searchElemRec(40));
		//System.out.println("search non rec "+btree.searchElemNonRec(76));
	//	System.out.println("ancestor of 50");
	//	btree.printAncestor(50);
		//System.out.println("Least Common Ancestor of 100 & 40 is "+btree.LeastCommonAncestor(20, 40).value);
        
	/*	BinaryTree btree1= new BinaryTree();
		btree1.insert(10);
		btree1.insert(30);
		btree1.insert(20);
		btree1.insert(70);
		btree1.insert(60);
		btree1.insert(50);
		btree1.insert(40);
		System.out.println(btree.isMirror(btree.root, btree1.root));*/
		/*CommonBinaryTreeApi commontree = new CommonBinaryTreeApi();
		int[] pre = {1,2,4,5,3,6,7};
		int[] in = {4,2,5,1,6,3,7};
		int[] post = {4,5,2,6,7,3,1};
		//Node root = commontree.buildTree_pre_in(pre,in,0, 6);
		Node root = commontree.buildTree_post_in(post, in, 0, 6);
		commontree.printInLevelOrder(root);*/
	    String s = "ab+cd-*";
	    Node root = new ExpressionTree().buildTree(s.toCharArray());
	    CommonBinaryTreeApi commontree = new CommonBinaryTreeApi();
	    commontree.printInLevelOrder(root);
				
	}

}
