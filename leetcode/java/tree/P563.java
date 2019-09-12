package leetcode.java.tree;

import leetcode.java.util.TreeNode;

public class P563 {

	private int ans;

	public int findTilt(TreeNode root) {
		ans = 0;
		dfs(root);
		return ans;
	}

	public int dfs(TreeNode node) {
		if (node == null) {
			return 0;
		}
		int left = dfs(node.left), right = dfs(node.right);
		ans += Math.abs(left - right);
		return node.val + left + right;
	}

}
