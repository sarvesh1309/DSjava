package com.practice.tree;

import com.practice.queue.Queue;

public class CommonBinaryTreeApi {
	public void printInLevelOrder(Node curr) {
		System.out.println("print levelorder");
		if (curr == null) {
			System.out.println("empty queue");
			return;
		}
		Queue q = new Queue();
		q.enQueue(curr);
		while (!q.isEmpty()) {
			Node tmp = (Node) q.deQueue();
			System.out.println(tmp.value + "\t");
			if (tmp.leftChild != null) {
				q.enQueue(tmp.leftChild);
			}
			if (tmp.rightChild != null) {
				q.enQueue(tmp.rightChild);
			}
		}
		q.deleteQueue();
	}
	
	static int startpre = 0;
	
	public Node buildTree_pre_in(int[] pre, int[]in,int startin, int endin){
		if(startin>endin) {
		return null;
		}
		Node newNode = new Node(pre[startpre]);
		startpre++;
		if(startin==endin) {
			return newNode;
		}
		int inIndex=0;
		for(int i=0;i<in.length;i++) {
			if(in[i]==newNode.value) {
				inIndex=i;
				break;
			}
		}
		
		newNode.leftChild=buildTree_pre_in(pre, in, startin, inIndex-1);
		newNode.rightChild=buildTree_pre_in(pre, in, inIndex+1, endin);
		return newNode;
	}
	
	static int startpost=6;
	public Node buildTree_post_in(int[] pre, int[]in,int startin, int endin){
		if(startin>endin) {
		return null;
		}
		Node newNode = new Node(pre[startpost]);
		startpost--;
		if(startin==endin) {
			return newNode;
		}
		int inIndex=0;
		for(int i=0;i<in.length;i++) {
			if(in[i]==newNode.value) {
				inIndex=i;
				break;
			}
		}
		
		newNode.rightChild=buildTree_post_in(pre, in, inIndex+1, endin);
		newNode.leftChild=buildTree_post_in(pre, in, startin, inIndex-1);
		return newNode;
	}

}
