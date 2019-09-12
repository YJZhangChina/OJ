package leetcode.java.tree;

import leetcode.java.util.TreeNode;

public class P1026 {

	private int ans;

	public int maxAncestorDiff(TreeNode root) {
		ans = 0;
		if (root != null) {
			dfs(root, root.val, root.val);
		}
		return ans;
	}

	public void dfs(TreeNode node, int min, int max) {
		int val = node.val;
		ans = Math.max(Math.abs(val - min), Math.abs(val - max));
		if (node.left != null) {
			dfs(node.left, Math.min(val, min), Math.max(val, max));
		}
		if (node.right != null) {
			dfs(node.right, Math.min(val, min), Math.max(val, max));
		}
	}

}
