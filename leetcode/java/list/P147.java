package leetcode.java.list;

import leetcode.java.util.ListNode;

public class P147 {

	public ListNode insertionSortList(ListNode head) {
		ListNode root = new ListNode(0);
		root.next = head;
		while (head.next != null) {
			if (head.next.val < head.val) {
				ListNode node = head.next;
				head.next = node.next;
				node.next = null;
				ListNode index = root;
				while (true) {
					System.out.println((node == null) + " " + (index.next == null));
					if (node.val <= index.next.val) {
						node.next = index.next;
						index.next = node;
						break;
					} else {
						node = node.next;
					}
				}
			} else {
				head = head.next;
			}
		}
		return root.next;
	}

}
