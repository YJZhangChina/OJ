package leetcode.java.list;

import leetcode.java.util.ListNode;

public class P708 {

	// Change 'ListNode' to 'Node'
	public ListNode insert(ListNode head, int val) {
		if (head == null) {
			head = new ListNode(val, head);
			return head;
		}
		ListNode node = head;
		while (true) {
			if (node.val < node.next.val && node.val <= val && val <= node.next.val) {
				node.next = new ListNode(val, node.next);
				break;
			} else if (node.val > node.next.val && (node.val <= val || val <= node.next.val)) {
				node.next = new ListNode(val, node.next);
				break;
			}
			if (node.next == head) {
                node.next = new ListNode(val, node.next);
                break;
            }
			node = node.next;
		}
		return head;
	}

}
