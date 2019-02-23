package com.practice.backtracking;

public class List {
	
	List next;
	Object value;
	List head;
	
	void nthNodeFromLast(int n) {
		
	}
	
	
	public List() {
		head=null;
		
	}
	
	
	public void insertAtStart(Object value) {
		List newNode = new List();
		newNode.value=value;
		newNode.next=head;
		head = newNode;
		System.out.println("inseted at start "+ value);
	}
	
	public void insertAtEnd(Object value) {
		List newNode = new List();
		List pr = head;
		newNode.value = value;
		if (head == null) {
			newNode.next = head;
			head = newNode;
		} else {
			while (pr.next != null) {
				pr = pr.next;
			}
			pr.next=newNode;
			newNode.next = null;
		}
		System.out.println("inseted at ENd "+ value);
	}
	
	public int getSize() {
		List pr = head;
		int count = 0;
		while(pr!=null) {
			count++;
			pr= pr.next;
		}
		return count;
	}
	
	public void printList() {
		List pr = head;
		if (head == null) {
			System.out.println("empty list");
		} else {
			while (pr!=null) {
				System.out.println(pr.value);
				pr = pr.next;
			}
		}

	}
	
	public Object delFromPosition(int pos) {
		Object obj=null;
		if(pos==1) {
			if(head!=null) {
				obj=head.value;
				head=head.next;
			}
		}else {
			List tmp=head;
			List q=null;
			int k=1;
			while(tmp!=null && k<pos) {
				q=tmp;
				tmp = tmp.next;
				k++;
			}
			if(k!=pos) {
				System.out.println("position "+pos+" does not exist");
				return 0;
			}
			// tmp node is pointing to the node that we need to delete 
			obj=tmp.value;
			q.next=tmp.next;
			
		}
		System.out.println("deleted position "+pos);
		return obj;
	}
	
	public void insertAtPosition(int pos, Object value){
		List newNode = new List();
		newNode.value=value;
	if(pos==1) {
		newNode.next=head;
		head=newNode;
	}else {
		List pr = head;
		List qr=null;
		int k=1;
		while(pr!=null && k<pos) {
			qr=pr;
			pr=pr.next;
			k++;
		}
		if(k!=pos) {
			System.out.println("position "+pos+" does not exist");
			return;
		}
		//tmp is pointing to the position where we need to add.
		newNode.next=qr.next;
		qr.next=newNode;
		System.out.println("inserted at position "+pos+" with value "+value);
	}
		
	}
	
	int get(int pos) {
		return pos;
		
	}
	
	int getLength() {
		return 0;
		
	}
}
