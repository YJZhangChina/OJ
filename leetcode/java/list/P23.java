package leetcode.java.list;

import leetcode.java.util.ListNode;

public class P23 {

	// needs for improvement
	public ListNode mergeKLists(ListNode[] lists) {
		if (lists.length == 0) {
			return null;
		}
		ListNode first = lists[0];
		for (int i = 1, j = lists.length; i < j; ++i) {
			first = mergeTwoLists(first, lists[i]);
		}
		return first;
	}

	public ListNode mergeTwoLists(ListNode first, ListNode second) {
		if (first == null) {
			return second;
		}
		if (second == null) {
			return first;
		}
		ListNode helper = new ListNode(0);
		ListNode current = helper;
		while (first != null && second != null) {
			if (first.val <= second.val) {
				current.next = first;
				first = first.next;
				current = current.next;
			} else {
				current.next = second;
				second = second.next;
				current = current.next;
			}
		}
		while (first != null) {
			current.next = first;
			first = first.next;
			current = current.next;
		}
		while (second != null) {
			current.next = second;
			second = second.next;
			current = current.next;
		}
		return helper.next;
	}

}
