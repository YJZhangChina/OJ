package leetcode.java.list;

import leetcode.java.util.ListNode;

public class P237 {

	public void deleteNode(ListNode node) {
		node.val = node.next.val;
		node.next = node.next.next;
	}

}
