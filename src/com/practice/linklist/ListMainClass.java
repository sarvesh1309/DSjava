package com.practice.linklist;

public class ListMainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Linklist list = new Linklist();
		list.insert(10);
		list.insert(20);
		list.insert(30);
		Linklist list2 = new Linklist();
		
		list2.insert(01);
		list2.insert(03);
		
		Linklist list3 = new Linklist();
		list3.insert(50);
		list3.insert(60);
        list3.insert(70);	
        
        //merging list3 at end of list1
        Node curr = list.head;
        while(curr.next!=null) {
        	curr=curr.next;
        }
        curr.next=list3.head;
        
        //merging list3 at end of list2
        curr = list2.head;
        while(curr.next!=null) {
        	curr=curr.next;
        }
        curr.next=list3.head;
        
        list.traverse();
        list2.traverse();
        
        MergePointUsingStack mergeVal = new MergePointUsingStack();
        System.out.println("merge point value is " +mergeVal.mergeNodeValue(list, list2));
        

	}

}
