package com.practice.queue;

import java.util.LinkedList;
import java.util.List;

public class Queue {
	List<Object> linkedList;
	public Queue() {
		linkedList = new LinkedList<Object>();
	}
	
	public void enQueue(Object value) {
		linkedList.add(value);
	}
	
	public Object deQueue() {
		Object deletedObj = linkedList.get(0);
		linkedList.remove(0);
		return deletedObj;
	}

	public void printQueue() {
		System.out.println(linkedList.toString());
	}
	public boolean isEmpty() {
		if (linkedList.isEmpty()) {
			return true;
		} else {
			return false;
		}
	}
	
	public void deleteQueue(){
		linkedList = null;
	}

}
