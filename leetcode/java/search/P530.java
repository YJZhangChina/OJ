package leetcode.java.search;

import leetcode.java.util.TreeNode;

public class P530 {

	long min = Long.MAX_VALUE;

	// Note that there are at least two nodes in this BST.
	public int getMinimumDifference(TreeNode root) {
		dfs(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
		return Long.valueOf(min).intValue();
	}

	public void dfs(TreeNode root, long left, long right) {
		min = Math.min(min, Math.min(root.val - left, right - root.val));
		if (root.left != null) {
			dfs(root.left, left, root.val);
		}
		if (root.right != null) {
			dfs(root.right, root.val, right);
		}
	}

}
