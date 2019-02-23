package com.practice.stack;

public class ReverseStack {
	
	void reverse(Stack s) {
		int len = s.size();
	   for(int i=0;i<len;i++) {
		   int data = (int)s.pop();
		   insertAtBottom(data, s);
	   }
	}
	
	void insertAtBottom(int data, Stack s) {
		if(s.isEmptyStack()) {
			s.push(data);
			return;
		}
		int temp=(int)s.pop();
		insertAtBottom(data, s);
		s.push(temp);
		
	}

}
