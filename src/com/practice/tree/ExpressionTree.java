package com.practice.tree;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class ExpressionTree {

	public Node buildTree(char[] expression) {
		Stack<Node> s = new Stack<Node>();
		Node node = null;
		for (int i = 0; i < expression.length; i++) {
			node = new Node(expression[i]);
			/*if (isUnaryOperator(expression[i])) {
				node.leftChild = s.pop();
				s.push(node);
			} else*/ if (isBinaryOperator(expression[i])) {
				node.rightChild = s.pop();
				node.leftChild = s.pop();
				s.push(node);
			} else {
				s.push(node);
			}
		}
		return node;
	}



	private boolean isBinaryOperator(char c) {
		Set<Character> s = new HashSet<Character>();
		s.add('+');
		s.add('-');
		s.add('*');
		s.add('/');
		s.add('/');
		if(s.contains(c)) {
			return true;
		}
		return false;
	}

	private boolean isUnaryOperator(char c) {
		// TODO Auto-generated method stub
		return false;
	}

}
