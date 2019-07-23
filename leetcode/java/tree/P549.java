package leetcode.java.tree;

import java.util.Arrays;

import leetcode.java.util.TreeNode;

public class P549 {

	private int ans = 0;

	public int longestConsecutive(TreeNode root) {
		if (root != null) {
			search(root);
		}
		return ans;
	}

	// Increase /; Decrease /; Increase \; Decrease \.
	public int[] search(TreeNode root) {
		int[] status = new int[] { 0, 0, 0, 0 };
		if (root.left == null && root.right == null) {
			ans = Math.max(ans, 1);
			return status;
		}
		if (root.left != null) {
			int[] left = search(root.left);
			status[0] += (root.val + 1 == root.left.val ? Math.max(left[0], left[2]) + 1 : 0);
			status[1] += (root.val - 1 == root.left.val ? Math.max(left[1], left[3]) + 1 : 0);
		}
		if (root.right != null) {
			int[] right = search(root.right);
			status[2] += (root.val + 1 == root.right.val ? Math.max(right[0], right[2]) + 1 : 0);
			status[3] += (root.val - 1 == root.right.val ? Math.max(right[1], right[3]) + 1 : 0);
		}
		int max = Math.max(status[0] + status[3], status[1] + status[2]) + 1;
		ans = Math.max(ans, max);
		return status;
	}

}
