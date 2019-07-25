package leetcode.java.tree;

import leetcode.java.util.TreeNode;

public class P404 {

	private int ans = 0;

	public int sumOfLeftLeaves(TreeNode root) {
		if (root != null) {
			search(root);
		}
		return ans;
	}

	public void search(TreeNode node) {
		if(node.left != null) {
			ans += node.left.val;
			search(node.left);
		}
		if(node.right != null) {
			search(node.right);
		}
	}

}
