package leetcode.java.list;

import leetcode.java.util.ListNode;

public class P328 {

	public ListNode oddEvenList(ListNode head) {
		ListNode headBefore = new ListNode(0), headAfter = new ListNode(0), before = headBefore, after = headAfter;
		int index = 1;
		while (head != null) {
			if (index % 2 != 0) {
				before.next = head;
				before = before.next;
			} else {
				after.next = head;
				after = after.next;
			}
			head = head.next;
		}
		before.next = headAfter.next;
		after.next = null;
		return headBefore.next;
	}

}
