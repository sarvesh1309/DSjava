package com.practice.leetcode;

public class Add2Numers {
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		ListNode l3 = null;

		int defer = 0;
		int val1 = 0;
		int val2 = 0;
		int val3 = 0;

		ListNode currNode = null;

		while (l1 != null || l2 != null || defer != 0) {
			if (l1 != null) {
				val1 = l1.val;
			} else {
				val1 = 0;
			}
			if (l2 != null) {
				val2 = l2.val;
			} else {
				val2 = 0;
			}
			val3 = val1 + val2 + defer;
			defer = val3 / 10;

			if (defer == 1) {
				val3 = val3 % 10;
			}
			if (l3 == null) {
				l3 = new ListNode(val3);
				currNode = l3;
			} else {
				ListNode newNode = new ListNode(val3);
				currNode.next = newNode;
				currNode = newNode;
			}
			if (l1 != null) {
				l1 = l1.next;
			}
			if (l2 != null) {
				l2 = l2.next;
			}

		}
		return l3;

	}

}
