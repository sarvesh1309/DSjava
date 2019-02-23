package com.practice.linklist;

public class JosephusCircle {
	
	
	public static void main(String s[]) {
		int personOnTable = Integer.parseInt(s[0]);
		int removedNumberFromTable = Integer.parseInt(s[1]);
		System.out.println(personOnTable + " " + removedNumberFromTable);
		
		//make a circle using linked list for personOnTable person
		listNode newNode=null;
		listNode head = new listNode(1);
		head.next=head;
		listNode tmp=head;
		if(personOnTable>1) {
			for(int i=2;i<=personOnTable;i++) {
			newNode = new listNode(i);
			tmp.next=newNode;
			tmp=tmp.next;
			}
			newNode.next=head;
		}
		//circular list complete
		listNode curr=head;
		//print
		traverse(head);
		//delete 3rd element from the list till only 1 remaining in list e.g 10 2
		while(personOnTable>1) {
			for(int i=1;i<(removedNumberFromTable-1);i++) {
				curr = curr.next;
			}
			System.out.println("deleting"+curr.next.value);
			//removing kth person
			curr.next = curr.next.next;
			//now the cursor is next to removed person
			curr=curr.next;
			personOnTable--;
		}
		
		System.out.println("leader is "+curr.value);
		
	}
	
	public static void traverse(listNode head) {
		listNode curr = head;
		System.out.println("printing circular linked list");
		do {
			System.out.println(curr.value);
			curr = curr.next;
		} while (curr != head);
	}
}

class listNode{
	int value;
	listNode next;
	public listNode(int value) {
	    this.value=value;
	}
}
