package leetcode.java.dfs;

import leetcode.java.util.TreeNode;

public class P965 {

	public boolean isUnivalTree(TreeNode root) {
		if (root == null) {
			return true;
		}
		int val = root.val;
		return dfs(root, val);
	}

	public boolean dfs(TreeNode root, int val) {
		if (root.val == val) {
			if (root.left == null && root.right == null) {
				return true;
			}
			boolean left = root.left != null ? dfs(root.left, val) : true;
			boolean right = root.right != null ? dfs(root.right, val) : true;
			return left && right;
		}
		return false;
	}

}
