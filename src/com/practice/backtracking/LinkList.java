package com.practice.backtracking;

public class LinkList {

	public static void main(String[] args) {
            LinkList list = new LinkList();
            list.listOperation();
	}
	
	void listOperation() {
		List list = new List();
		list.insertAtStart(20);
		list.insertAtEnd(30);
		list.insertAtStart(10);
		list.insertAtEnd(40);
		list.insertAtPosition(7, 25);
		
	}

}

