package leetcode.java.list;

import leetcode.java.util.ListNode;

public class P725 {

	public ListNode[] splitListToParts(ListNode root, int k) {
		int size = getSize(root);
		ListNode[] ans = new ListNode[k];
		int m = size / k, n = size % k;
		ListNode current = root;
		for (int i = 0; i < k; ++i) {
			ListNode node = new ListNode(0), temp = node;
			for (int p = 0, q = m + n > 0 ? 1 : 0; p < q; ++p) {
				temp.next = new ListNode(current.val);
				temp = temp.next;
				current = current.next;
			}
			--n;
			ans[i] = node.next;
		}
		return ans;
	}

	public int getSize(ListNode head) {
		int ans = 0;
		while (head != null) {
			head = head.next;
			++ans;
		}
		return ans;
	}

}
