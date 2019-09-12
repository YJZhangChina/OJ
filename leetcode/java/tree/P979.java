package leetcode.java.tree;

import leetcode.java.util.TreeNode;

public class P979 {

	private int ans = 0;

	public int distributeCoins(TreeNode root) {
		dfs(root, null);
		return ans;
	}

	public void dfs(TreeNode child, TreeNode parent) {
		if (child == null) {
			return;
		}
		dfs(child.left, child);
		dfs(child.right, child);
		if (child.val != 1) {
			ans += Math.abs(child.val - 1);
			parent.val += (child.val - 1);
		}
	}

}
