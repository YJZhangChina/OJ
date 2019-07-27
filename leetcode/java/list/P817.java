package leetcode.java.list;

import java.util.HashSet;
import java.util.Set;

import leetcode.java.util.ListNode;

public class P817 {

	public int numComponents(ListNode head, int[] nums) {
		int ans = 0;
		Set<Integer> set = new HashSet<>(nums.length);
		for (int num : nums) {
			set.add(num);
		}
		while (head != null) {
			if (set.contains(head.val) && (head.next == null || !set.contains(head.next.val))) {
				++ans;
			}
			head = head.next;
		}
		return ans;
	}

}
