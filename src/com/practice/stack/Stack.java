package com.practice.stack;

public class Stack {
	int top;
	int maxSize;
	Object s[];
	int count;

	public Stack(int n ) {
		maxSize=n;
		top=-1;
		s=new Object[maxSize];
	}
	public boolean isEmptyStack() {
		if(top==-1) {
			return true;
		}else {
				return false;
		}
	}

	public void push(Object str) {
		if (top < maxSize-1) {
			top = top + 1;
			s[top] = str;
			count++;
		} else {
			System.out.println("stack is full");
		}

	}
	public Object pop() {
		if(isEmptyStack()) {
			System.out.println("stack is empty");
			return null;
		}else {
			Object str=s[top];
			top=top-1;
			count--;
			return str;
			
		}
	}
	public Object peek() {
		if(isEmptyStack()) {
			System.out.println("stack is empty");
			return null;
		}else {
			Object str=s[top];
			return str;
		}
	}
	
	public int size() {
		return count;
	}
	
}
