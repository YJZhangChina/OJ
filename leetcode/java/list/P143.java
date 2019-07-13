package leetcode.java.list;

import java.util.Stack;

import leetcode.java.util.ListNode;

public class P143 {

	public void reorderList(ListNode head) {
		if (head != null) {
			ListNode midium = getMidium(head), fool = midium;
			Stack<ListNode> stack = new Stack<ListNode>();
			while (fool.next != null) {
				stack.add(fool.next);
				fool = fool.next;
			}
			midium.next = null;
			fool = head;
			while (!stack.isEmpty()) {
				ListNode node = stack.pop();
				node.next = fool.next;
				fool.next = node;
				fool = node.next;
			}
		}
	}

	public ListNode getMidium(ListNode head) {
		ListNode slow = head, fast = head;
		while (fast.next != null && fast.next.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}
		return slow;
	}

}
