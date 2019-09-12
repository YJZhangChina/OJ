package leetcode.java.list;

import leetcode.java.util.ListNode;

public class P203 {

	public ListNode removeElements(ListNode head, int val) {
		ListNode fool = new ListNode(0), ans = fool;
		fool.next = head;
		while (fool.next != null) {
			if (fool.next.val == val) {
				fool.next = fool.next.next;
			} else {
				fool = fool.next;
			}
		}
		return ans.next;
	}

}
