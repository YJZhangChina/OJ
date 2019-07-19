package leetcode.java.list;

import leetcode.java.util.ListNode;

public class P160 {

	public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
		if (headA == null || headB == null) {
			return null;
		}
		int lengthA = getLength(headA), lengthB = getLength(headB);
		ListNode nodeA = headA, nodeB = headB;
		if (lengthA != lengthB) {
			int step = Math.abs(lengthA - lengthB);
			if (lengthA < lengthB) {
				while (step-- > 0) {
					nodeA = nodeA.next;
				}
			} else {
				while (step-- > 0) {
					nodeB = nodeB.next;
				}
			}
		}
		while (nodeA != null) {
			if (nodeA.val == nodeB.val) {
				return nodeA;
			}
			nodeA = nodeA.next;
			nodeB = nodeB.next;
		}
		return null;
	}

	private int getLength(ListNode node) {
		int length = 1;
		while (node.next != null) {
			node = node.next;
			++length;
		}
		return length;
	}

}
