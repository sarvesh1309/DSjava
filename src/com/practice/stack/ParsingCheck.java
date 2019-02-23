package com.practice.stack;

public class ParsingCheck {
	
	public boolean isCorrectExp(String str) {
		Stack s = new Stack(20);
		for (int i = 0; i < str.length(); i++) {
			char c = str.charAt(i);
			if (c == '(' || c == '{' || c == '[') {
				s.push(c);
			}
			
			if (c == ')' || c == '}' || c == ']') {
				if(!s.isEmptyStack()) {
				char ch = (char) s.peek();
				if ((c == ')' && ch == '(') || (c == '}' && ch == '{') || (c == ']' && ch == '[')) {
					ch=(char)s.pop();
					System.out.println("popped is " + ch);
				}else {
					System.out.println("parsing error");
				}
				}
			}
		}
		return  s.isEmptyStack();
	}

}
