package leetcode.java.dfs;

import leetcode.java.util.TreeNode;

public class P543 {

	public int diameterOfBinaryTree(TreeNode root) {
		if (root == null) {
			return 0;
		}
		return Math.max(maxDepth(root.left) + maxDepth(root.right),
				Math.max(diameterOfBinaryTree(root.left), diameterOfBinaryTree(root.right)));
	}

	public int maxDepth(TreeNode node) {
		return node == null ? 0 : Math.max(maxDepth(node.left), maxDepth(node.right)) + 1;
	}

}
