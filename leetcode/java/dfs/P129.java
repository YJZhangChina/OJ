package leetcode.java.dfs;

import leetcode.java.util.TreeNode;

public class P129 {

	int ans = 0;

	public int sumNumbers(TreeNode root) {
		if (root != null) {
			dfs(root, 0);
		}
		return ans;
	}

	public void dfs(TreeNode root, int current) {
		if (root.left == null && root.right == null) {
			ans += (current * 10 + root.val);
		}
		if (root.left != null) {
			dfs(root.left, current * 10 + root.val);
		}
		if (root.right != null) {
			dfs(root.right, current * 10 + root.val);
		}
	}
}
