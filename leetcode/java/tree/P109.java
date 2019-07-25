package leetcode.java.tree;

import leetcode.java.util.ListNode;
import leetcode.java.util.TreeNode;

public class P109 {

	public TreeNode sortedListToBST(ListNode head) {
		if (head == null) {
			return null;
		}
		return convert(head);
	}

	public TreeNode convert(ListNode list) {
		if (list.next == null) {
			return new TreeNode(list.val);
		} else if (list.next.next == null) {
			TreeNode tree = new TreeNode(list.next.val);
			tree.left = new TreeNode(list.val);
			return tree;
		} else {
			ListNode midium = getMidium(list);
			ListNode foo = list;
			while (foo.next != midium) {
				foo = foo.next;
			}
			foo.next = null;
			TreeNode tree = new TreeNode(midium.val);
			tree.left = convert(list);
			tree.right = convert(midium.next);
			return tree;
		}
	}


	public ListNode getMidium(ListNode list) {
		ListNode slow = list, fast = list;
		while (fast.next != null && fast.next.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}
		return slow;
	}

}
