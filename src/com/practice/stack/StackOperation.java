package com.practice.stack;


public class StackOperation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Stack stack = new Stack(3);
		stack.push(30);
		stack.push(20);
		
		stack.push(40);
		ReverseStack rev= new ReverseStack();
		rev.reverse(stack);
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		
		//ParsingCheck par = new ParsingCheck();
		//System.out.println("expression is "+par.isCorrectExp("(a+b)-c{(}"));

	}

}
