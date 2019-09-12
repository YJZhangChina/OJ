package leetcode.java.tree;

import leetcode.java.util.TreeNode;

public class P1022 {

	private int ans;

	public int sumRootToLeaf(TreeNode root) {
		if (root != null) {
			dfs(root, Integer.valueOf(root.val));
		}
		return ans;
	}

	public void dfs(TreeNode node, int value) {
		if (node.left == null && node.right == null) {
			ans += value;
		}
		value = (value << 1) + Integer.valueOf(node.val);
		if (node.left != null) {
			dfs(node.left, value);
		}
		if (node.right != null) {
			dfs(node.right, value);
		}
	}

}
