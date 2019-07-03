package leetcode.java.dfs;

import leetcode.java.util.TreeNode;

public class P124 {

	int ans = Integer.MIN_VALUE;

	public int maxPathSum(TreeNode root) {
		if (root == null) {
			return 0;
		}
		maxValue(root);
		return ans;
	}

	public int maxValue(TreeNode node) {
		if (node == null) {
			return 0;
		}
		int left = maxValue(node.left), right = maxValue(node.right);
		int value = node.val;
		if (left > 0) {
			value += left;
		}
		if (right > 0) {
			value += right;
		}
		ans = Math.max(ans, value);
		return node.val + Math.max(0, Math.max(maxValue(node.left), maxValue(node.right)));
	}

}
