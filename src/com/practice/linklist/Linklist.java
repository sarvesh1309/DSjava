package com.practice.linklist;

public class Linklist {
	public Node head;
	int length;
	/**
	 * insert at last 
	 */
	public void insert(int value) {
		if(head==null) {
			//insert as a first element
			head = new Node(value);
			return;
		}
		Node newNode = new Node(value);
		Node curr=head;
		while(curr.next!=null) {
			curr=curr.next;
		}
		curr.next=newNode;
		
	}
	public void insert(int value, int pos) {
		if(pos==1) {
			Node newNode=new Node(value);
			newNode.next=head;
			head=newNode;
			return;
		}
		Node tmp=null;
		Node curr=head;
		int i=0;
		while(i<pos-1 && curr!=null) {
			i++;
			tmp=curr;
			curr=curr.next;
		}
		if(i!=pos-1) {
			System.out.println("incorrect position");
		}else {
			Node newNode= new Node(value);
			tmp.next=newNode;
			newNode.next=curr;
		}
		
	}
	/**
	 * delete from last position
	 */
	public void delete() {
		if(head==null) {
			System.out.println("empty list");
			return;
		}
		Node curr=head;
		Node tmp=null;
		while(curr.next!=null) {
			tmp=curr;
			curr=curr.next;
		}
		tmp.next=null;
	}
	
	public void delete(int pos) {
		if(head==null) {
			System.out.println("empty list");
			return;
		}
		int i=0;
		Node tmp=null;
		Node curr=head;
		while(i<pos-1 && curr!=null) {
			i++;
			tmp=curr;
			curr=curr.next;
		}
		if(curr==null) {
			System.out.println("incorrect position");
		}else {
			tmp.next=curr.next;
		}
		
	}
	public int length() {
		Node curr=head;
		int count=0;
		while(curr.next!=null) {
			curr=curr.next;
			count++;
		}
		return count;
		
	}
	public void traverse() {
		Node curr=head;
		while(curr!=null) {
			System.out.println(curr.value);
			curr=curr.next;
		}
	}
	
	//will be implemented after sorting chapter
	public void  sortList() {
		
	}
	public void reverselist() {
		Node tmp=null;
		Node curr=head;
		while(curr!=null) {
			head=head.next;
			curr.next=tmp;
			tmp=curr;
			curr=head;
		}
		head=tmp;
				
	}
	

	
}

class Node{
	Node next;
	int value;
	public Node(int value) {
		this.value=value;
	}
}
