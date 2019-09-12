package leetcode.java.list;

import leetcode.java.util.ListNode;

public class P86 {

	public ListNode partition(ListNode head, int x) {
		ListNode beforeHead = new ListNode(0), afterHead = new ListNode(0), before = beforeHead, after = afterHead;
		while (head != null) {
			if (head.val < x) {
				before.next = head;
				before = before.next;
			} else {
				after.next = head;
				after = after.next;
			}
			head = head.next;
		}
		before.next = afterHead.next;
		after.next = null;
		return beforeHead.next;
	}

}
