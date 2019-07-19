package leetcode.java.list;

import leetcode.java.util.ListNode;

public class P2 {

	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		boolean flag = false;
		ListNode root = new ListNode(0), node = root;
		while (l1 != null && l2 != null) {
			int val = l1.val + l2.val + (flag ? 1 : 0);
			flag = val > 9;
			node.next = new ListNode(val % 10);
			l1 = l1.next;
			l2 = l2.next;
			node = node.next;
		}
		while (l1 != null) {
			int val = l1.val + (flag ? 1 : 0);
			flag = val > 9;
			node.next = new ListNode(val % 10);
			l1 = l1.next;
			node = node.next;
		}
		while (l2 != null) {
			int val = l2.val + (flag ? 1 : 0);
			flag = val > 9;
			node.next = new ListNode(val % 10);
			l2 = l2.next;
			node = node.next;
		}
		if (flag) {
			node.next = new ListNode(1);
		}
		return root.next;
	}

}
