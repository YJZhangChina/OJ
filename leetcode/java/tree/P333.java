package leetcode.java.tree;

import leetcode.java.util.TreeNode;

public class P333 {

	private int ans = 0;

	public int largestBSTSubtree(TreeNode root) {
		if (root != null) {
			search(root);
		}
		return ans;
	}

	// 0: value
	// 1: /<
	// 2: />
	// 3: \<
	// 4: \>
	// 5: valid
	// 6: count
	public int[] search(TreeNode node) {
		int[] status = new int[] { node.val, Integer.MAX_VALUE, node.val, node.val, Integer.MIN_VALUE, 1, 1 };
		if (node.left == null && node.right == null) {
			ans = Math.max(ans, 1);
			return status;
		}
		if (node.left != null) {
			int[] left = search(node.left);
			if (left[5] == 1 && status[0] < left[1] && status[0] > left[2]) {
				status[3] = Math.min(status[3], left[3]);
				status[4] = Math.max(status[4], left[4]);
			} else {
				status[5] = 0;
			}
			status[6] += left[6];
		}
		if (node.right != null) {
			int[] right = search(node.right);
			if (right[5] == 1 && status[0] < right[3] && status[0] > right[4]) {
				status[1] = Math.min(status[1], right[1]);
				status[2] = Math.max(status[2], right[2]);
			} else {
				status[5] = 0;
			}
			status[6] += right[6];
		}
		if (status[5] == 1) {
			ans = Math.max(ans, status[6]);
		}
		return status;
	}

}
