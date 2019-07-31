package leetcode.java.tree;

import leetcode.java.util.TreeNode;

public class P783 {

	private TreeNode previous = null;
	private int ans = Integer.MAX_VALUE;

	public int minDiffInBST(TreeNode root) {
		inorder(root);
		return ans;
	}

	public void inorder(TreeNode node) {
		if (node == null) {
			return;
		}
		inorder(node.left);
		if (previous != null) {
			ans = Math.min(ans, node.val - previous.val);
		}
		previous = node;
		inorder(node.right);
	}

}
