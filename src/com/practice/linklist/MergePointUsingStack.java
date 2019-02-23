package com.practice.linklist;

import com.practice.stack.Stack;

public class MergePointUsingStack {
	
	int mergeNodeValue(Linklist list1, Linklist list2) {
		Stack stack1 = new Stack(20);
		Stack stack2 = new Stack(20);
		Node curr = list1.head;
		while (curr != null) {
			stack1.push(curr);
			curr = curr.next;
		}
		curr = list2.head;
		while (curr != null) {
			stack2.push(curr);
			curr = curr.next;
		}
		Node commonNode=null;
		while(!stack1.isEmptyStack() || !stack2.isEmptyStack()) {
			Node temp1=(Node) stack1.pop();
			Node temp2=(Node) stack2.pop();
			if(temp1!=temp2) {
				break;
			}else {
				commonNode = temp1;
			}
		}
		if(commonNode==null) {
			System.out.println("there is no merge of two link list");
			return -1;
		}
		return commonNode.value;
		
	}

}
