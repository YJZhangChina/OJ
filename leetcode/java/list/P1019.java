package leetcode.java.list;

import java.util.Comparator;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;
import java.util.TreeSet;

import leetcode.java.util.ListNode;

public class P1019 {

	public int[] nextLargerNodes(ListNode head) {
		Stack<ListNode> stack = toStack(head);
		int size = stack.size();
		int[] ans = new int[size];
		Deque<Integer> queue = new LinkedList<>();
		queue.add(stack.pop().val);
		for (int i = size - 1 - 1; i >= 0; --i) {
			ListNode node = stack.pop();
			while (!queue.isEmpty()) {
				if (node.val >= queue.peek()) {
					queue.pop();
				} else {
					ans[i] = queue.peek();
					queue.addFirst(node.val);
                    break;
				}
			}
			if(queue.isEmpty()) {
				queue.addFirst(node.val);
			}
            
		}
		return ans;
	}

	public Stack<ListNode> toStack(ListNode head) {
		Stack<ListNode> stack = new Stack<ListNode>();
		while (head != null) {
			stack.push(head);
			head = head.next;
		}
		return stack;
	}

}
