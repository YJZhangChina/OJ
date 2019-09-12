package leetcode.java.dfs;

import leetcode.java.util.TreeNode;

public class P687 {

	public int longestUnivaluePath(TreeNode root) {
		if (root == null) {
			return 0;
		}
		int value = maxPathByValue(root.left, root.val) + maxPathByValue(root.right, root.val);
		return Math.max(value, Math.max(longestUnivaluePath(root.left), longestUnivaluePath(root.right)));
	}

	public int maxPathByValue(TreeNode node, int val) {
		if (node == null || node.val != val) {
			return 0;
		}
		return Math.max(maxPathByValue(node.left, val), maxPathByValue(node.right, val)) + 1;
	}

}
