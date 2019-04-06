package leetcode.java.dfs;

import leecode.java.util.TreeNode;

public class P104 {
	public int maxDepth(TreeNode root) {
		if (root == null) {
			return 0;
		}
		if (root.left == null && root.right == null) {
			return 1;
		}
		return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
	}
}
